package proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-07
 */
public class SubClass implements MethodInterceptor
{
    /**
     * 代理类需要代理的方法
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable
    {
        System.out.println("MethodInterceptor start...");

        Object result = methodProxy.invokeSuper(obj, args);

        System.out.println("MethodInterceptor end...");

        return result;
    }
}
