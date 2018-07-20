package designPatterns.SingletonPattern;

/**
 * @description: 3.饿汉式
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * <p>
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 * @author: Liu Cong
 * @create: Created at 2018-06-19
 */
public class Singleton3
{
    private static Singleton3 instance = new Singleton3();

    private Singleton3()
    {
    }

    public static Singleton3 getInstance()
    {
        return instance;
    }
}
