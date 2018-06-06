package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Testable
{
    public void execute()
    {
        System.out.println("Executing...");
    }

    // 使用注解
    @Test
    void testExecute()
    {
        execute();
    }

    // 定义注解
    @Target(ElementType.METHOD) // 定义@Test注解将应用于什么地方(例如，一个方法、一个域)
    @Retention(RetentionPolicy.RUNTIME)         // 定义@Test注解在哪一个级别可用(例如，源代码中SOURCE、类文件CLASS、运行时RUNTIME)
    private static @interface Test
    {
    }
}
