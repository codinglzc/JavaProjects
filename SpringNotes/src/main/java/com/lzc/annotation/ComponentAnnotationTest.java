package com.lzc.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * <p>
 * 通过 @Component 注解实现自定义的注解，被 Spring 加载成 bean。
 * 运行这个例子，就会发现，@MyComponent 注解的类，也被Spring加载进来了，而且可以当成普通的JavaBean正常的使用。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-08
 */
@Configuration
public class ComponentAnnotationTest
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ComponentAnnotationTest.class);
        annotationConfigApplicationContext.refresh();

        InjectClass injectClass = annotationConfigApplicationContext.getBean(InjectClass.class);
        injectClass.print();
    }

    @MyComponent
    public static class InjectClass
    {
        public void print()
        {
            System.out.println("hello word");
        }
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Component
    public @interface MyComponent
    {
        String value() default "";
    }
}
