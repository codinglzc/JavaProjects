package designPatterns.SingletonPattern;

/**
 * @description: 1.懒汉式，线程不安全
 * 是否 Lazy 初始化：是
 * 是否多线程安全：否
 * @author: Liu Cong
 * @create: Created at 2018-06-19
 */
public class Singleton1
{
    private static Singleton1 instance;

    private Singleton1()
    {
    }

    public static Singleton1 getInstance()
    {
        if (instance == null)
        {
            instance = new Singleton1();
        }
        return instance;
    }
}
