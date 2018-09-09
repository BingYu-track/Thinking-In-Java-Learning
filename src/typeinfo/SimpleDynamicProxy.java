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
    }
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // Insert a proxy and call again:
        Interface proxy = (Interface)Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{ Interface.class },
                new DynamicProxyHandler(real)
        );
        consumer(proxy);
    }
}
