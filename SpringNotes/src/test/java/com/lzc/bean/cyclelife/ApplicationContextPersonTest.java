package com.lzc.bean.cyclelife;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-07
 */
public class ApplicationContextPersonTest
{
    public static void main(String[] args)
    {
        System.out.println("开始初始化容器");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-context.xml");
        System.out.println("xml 加载完毕");
        Person person1 = (Person) ac.getBean("person1");
        System.out.println(person1);
        System.out.println("关闭容器");
        ((ClassPathXmlApplicationContext) ac).close();
    }
}
