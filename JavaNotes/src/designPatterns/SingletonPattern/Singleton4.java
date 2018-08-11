package designPatterns.SingletonPattern;

/**
 * @description: 4.双检锁/双重校验锁（DCL，即 double-checked locking）
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 * @author: Liu Cong
 * @create: Created at 2018-06-19
 */
public class Singleton4
{
    //    private static Singleton4 instance;

    // 通过volatile关键字来确保安全，防止在执行步骤4的的时候发生重排序
    private volatile static Singleton4 instance;

    private Singleton4()
    {
    }

    public static Singleton4 getInstance()
    {
        if (instance == null)                       // 1
        {
            synchronized (Singleton4.class)         // 2
            {
                if (instance == null)               // 3
                {
                    instance = new Singleton4();    // 4
                }
            }
        }
        return instance;
    }
}
