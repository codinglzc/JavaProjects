package proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-07
 */
public class ProxyTest
{
    public static void main(String[] args)
    {
        OriginInterface target = new OriginImpl();

        OriginInterface proxy = (OriginInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new OriginProxy(target));

        proxy.testProxy();
    }
}
