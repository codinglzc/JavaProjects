package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-07
 */
public class OriginProxy implements InvocationHandler
{
    private Object target;

    public OriginProxy(OriginInterface target)
    {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("begin invoke method.");

        Object result = method.invoke(target, args);

        System.out.println("end invoke method.");

        return result;
    }
}
