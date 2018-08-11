package com.lzc.annotation;

import com.lzc.annotation.scan.CustomizeComponent;
import com.lzc.annotation.scan.ScanClass1;
import net.sf.cglib.core.NamingPolicy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

/**
 * <p>
 * test for customer
 * 1 BeanFactoryPostProcessor after bean factory is created,scan and modify bean definition
 * 2 BeanDefinition , bean class , if a basic class, auto ,else if a factory bean ,create by factory bean
 * 3 FactoryBean , create bean
 * 4 Scan ,basic scan
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-08
 */
@Configuration
@SuppressWarnings("unchecked")
public class CustomizeScanTest
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(CustomizeScanTest.class);
        annotationConfigApplicationContext.refresh();

        ScanClass1 injectClass = annotationConfigApplicationContext.getBean(ScanClass1.class);
        injectClass.print();
    }

    @Component
    public static class BeanScannerConfigurer implements BeanFactoryPostProcessor, ApplicationContextAware
    {
        private ApplicationContext applicationContext;

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
        {
            Scanner scanner = new Scanner((BeanDefinitionRegistry) beanFactory);
            scanner.setResourceLoader(this.applicationContext);
            scanner.scan("com.lzc.annotation");
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
        {
            this.applicationContext = applicationContext;
        }
    }

    public static class Scanner extends ClassPathBeanDefinitionScanner
    {
        public Scanner(BeanDefinitionRegistry registry)
        {
            super(registry);
        }

        @Override
        protected void registerDefaultFilters()
        {
            this.addIncludeFilter(new AnnotationTypeFilter(CustomizeComponent.class));
        }

        @Override
        protected Set<BeanDefinitionHolder> doScan(String... basePackages)
        {
            Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
            for (BeanDefinitionHolder holder : beanDefinitions)
            {
                GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();
                definition.getPropertyValues().add("innerClassName", definition.getBeanClassName());
                definition.setBeanClass(FactoryBeanTest.class);
            }
            return beanDefinitions;
        }

        @Override
        protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition)
        {
            return super.isCandidateComponent(beanDefinition) &&
                    beanDefinition.getMetadata().hasAnnotation(CustomizeComponent.class.getName());
        }
    }

    public class FactoryBeanTest<T> implements InitializingBean, FactoryBean<T>
    {
        private String innerClassName;

        public void setInnerClassName(String innerClassName)
        {
            this.innerClassName = innerClassName;
        }

        @Override
        public T getObject() throws Exception
        {
            Class innerClass = Class.forName(innerClassName);
            if (innerClass.isInterface())
                return (T) InterfaceProxy.<Object>newInstance(innerClass);
            else
            {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(innerClass);
                enhancer.setCallback(new MethodInterceptorImpl());
//                enhancer.setNamingPolicy((NamingPolicy) SpringNamingPolicy.INSTANCE);
                return (T) enhancer.create();
            }
        }

        @Override
        public Class<?> getObjectType()
        {
            try
            {
                return Class.forName(innerClassName);
            } catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public boolean isSingleton()
        {
            return true;
        }

        @Override
        public void afterPropertiesSet() throws Exception
        {

        }
    }

    public static class InterfaceProxy implements InvocationHandler
    {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
        {
            System.out.println("ObjectProxy execute: " + method.getName());
            return method.invoke(proxy, args);
        }

        public static <T> T newInstance(Class<T> innerInterface)
        {
            ClassLoader classLoader = innerInterface.getClassLoader();
            Class[] interfaces = new Class[]{innerInterface};
            InterfaceProxy proxy = new InterfaceProxy();
            return (T) Proxy.newProxyInstance(classLoader, interfaces, proxy);
        }
    }

    public static class MethodInterceptorImpl implements MethodInterceptor
    {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable
        {
            System.out.println("MethodInterceptorImpl: " + method.getName());
            return proxy.invokeSuper(obj, args);
        }
    }
}
