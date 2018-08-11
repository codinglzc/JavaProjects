package com.lzc.bean.cyclelife;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-07
 */
public class BeanFactoryPersonTest
{
    public static void main(String[] args)
    {
        System.out.println("开始初始化容器");
        ConfigurableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-context.xml"));
        System.out.println("XML 加载完毕");

        // beanFactory 需要手动注册 beanPostProcessor 类的方法
        bf.addBeanPostProcessor(new MyBeanPostProcessor());

        Person person1 = (Person) bf.getBean("person1");
        System.out.println(person1);

        System.out.println("关闭容器");
        bf.destroySingletons();
    }
}
