package typeinfo;

import java.lang.reflect.Proxy;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/9 21:17
 */
class E23_SimpleDynamicProxyDemo2 {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        Interface proxy = (Interface)Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class<?>[]{ Interface.class },
                new DynamicProxyHandler2(real)
        );
        consumer(proxy);
    }
}
