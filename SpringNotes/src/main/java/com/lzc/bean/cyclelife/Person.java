package com.lzc.bean.cyclelife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-07
 */
public class Person implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean
{
    private String name;

    public Person()
    {
        System.out.println("Person 类的构造方法");
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
        System.out.println("setName() 方法被调用");
    }

    // 自定义的初始化方法
    public void myInit()
    {
        System.out.println("myInit() 被调用");
    }

    // 自定义的销毁方法
    public void myDestroy()
    {
        System.out.println("myDestroy() 被调用");
    }

    // =========================================
    // 实现 BeanNameAware 接口的方法
    // =========================================
    @Override
    public void setBeanName(String beanName)
    {
        System.out.println("setBeanName() 被调用，beanName: " + beanName);
    }

    // =========================================
    // 实现 BeanFactoryAware 接口的方法
    // =========================================
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException
    {
        System.out.println("setBeanFactory() 被调用，beanFactory: " + beanFactory.toString());
    }

    // =========================================
    // 实现 ApplicationContextAware 接口的方法
    // =========================================
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        System.out.println("setApplicationContext() 被调用，applicationContext: " + applicationContext.toString());
    }

    // =========================================
    // 实现 InitializingBean 接口的方法
    // =========================================
    @Override
    public void afterPropertiesSet() throws Exception
    {
        System.out.println("afterPropertiesSet() 被调用");
    }

    // =========================================
    // 实现 DisposableBean 接口的方法
    // =========================================
    @Override
    public void destroy() throws Exception
    {
        System.out.println("destroy() 被调用");
    }

    @Override
    public String toString()
    {
        return "[Person name: " + name + "]";
    }
}
