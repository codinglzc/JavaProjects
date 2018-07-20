package java8.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description: 函数式接口实例
 * Predicate <T> 接口是一个函数式接口，它接受一个输入参数 T，返回一个布尔值结果。
 * <p>
 * 该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）。
 * <p>
 * 该接口用于测试对象是 true 或 false。
 * @author: Liu Cong
 * @create: Created at 2018-06-09
 */
public class FunctionalInterfaceTest1
{
    public static void eval(List<Integer> list, Predicate<Integer> predicate)
    {
        for (Integer n : list)
        {
            if (predicate.test(n))
            {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        List<Integer> predicate = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("输出所有数据：");
        eval(predicate, n -> true);

        System.out.println("输出所有偶数：");
        eval(predicate, n -> n % 2 == 0);

        System.out.println("输出所有大于3的数：");
        eval(predicate, n -> n > 3);
    }
}
