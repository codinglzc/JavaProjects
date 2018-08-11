package proxy.cglib;

/**
 * <p>
 * 被代理的类
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-07
 */
public class SuperClass
{
    public void hello(String name)
    {
        System.out.println("hello, " + name);
    }

    public void bye(String name)
    {
        System.out.println("bye, " + name);
    }
}
