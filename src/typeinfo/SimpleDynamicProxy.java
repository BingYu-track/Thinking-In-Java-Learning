package typeinfo;

import java.lang.reflect.Proxy;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/9 20:03
 */
public class SimpleDynamicProxy {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
        System.out.println("---------------------");
    }
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // Insert a proxy and call again: 代理对象proxy
        Interface proxy = (Interface)Proxy.newProxyInstance(
                Interface.class.getClassLoader(), //类加载器
                new Class[]{ Interface.class }, //希望代理实现的接口列表(不能是类或抽象类)
                new DynamicProxyHandler(real) //InvocationHandler接口的一个实现；还要向Handler传递一个真正的对象
        );
        consumer(proxy);
    }
}
