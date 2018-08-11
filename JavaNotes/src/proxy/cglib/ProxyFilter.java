package proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * <p>
 * 过滤器
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-07
 */
public class ProxyFilter implements CallbackFilter
{
    /**
     * 只对被代理的bye()方法进行增加
     */
    @Override
    public int accept(Method method)
    {
        if ("bye".equals(method.getName()))
            return 0;
        return 1;
    }
}
