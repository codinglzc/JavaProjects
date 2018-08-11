package com.lzc.bean.cyclelife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-07
 */
public class MyBeanPostProcessor implements BeanPostProcessor
{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("postProcessBeforeInitialization() 被调用");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("postProcessBeforeInitialization() 被调用");
        return bean;
    }
}
