package proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-07
 */
public class CGLibTest
{
    public static void main(String[] args)
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SuperClass.class); // 设置被代理的类
        enhancer.setCallbacks(new Callback[]{new SubClass(), NoOp.INSTANCE}); // 根据SubClass中的实现对方法进行增强
        enhancer.setCallbackFilter(new ProxyFilter()); // 使用过滤器

        SuperClass create = (SuperClass) enhancer.create();


        create.hello("ken");
        // 使用 enhance 产生的代理类不需要修改 SuperClass 类中的代码，就可以对 bye() 进行增强
        create.bye("ken");
    }
}
