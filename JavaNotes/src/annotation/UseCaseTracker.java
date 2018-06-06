package annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: ${description}
 * @Author: lzc
 * @Date: Created at 2018-06-04
 */
public class UseCaseTracker
{
    public static void trackUseCases(List<Integer> useCases, Class<?> cl)
    {
        for (Method m : cl.getDeclaredMethods())    // 获得cl的方法
        {
            PasswordUtils.UseCase uc = m.getAnnotation(PasswordUtils.UseCase.class);    // 获得指定类型的注解对象
            if (uc != null)
            {
                System.out.println("Found Use Case:" + uc.id() + " " + uc.description()); // 通过调用id()和description()方法从返回的UseCase对象中提取元素的值
                useCases.remove(new Integer(uc.id()));
            }
        }

        for (int i : useCases)
            System.out.println("Warning: Missing use case-" + i);
    }

    public static void main(String[] args)
    {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
