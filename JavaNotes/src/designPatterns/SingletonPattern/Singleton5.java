package designPatterns.SingletonPattern;

/**
 * @description: 5.登记式/静态内部类
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 描述：这种方式能达到双检锁方式一样的功效，但实现更简单。
 * @author: Liu Cong
 * @create: Created at 2018-06-19
 */
public class Singleton5
{
    private static class SingletonHolder
    {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    private Singleton5()
    {
    }

    public static Singleton5 getInstance()
    {
        return SingletonHolder.INSTANCE;
    }
}
