package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/9 21:16
 */
class DynamicProxyHandler2 implements InvocationHandler {

    private Object proxied;
    public DynamicProxyHandler2(Object proxied) {
        this.proxied = proxied;
    }
    public Object
    invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy: " + proxy);
        return method.invoke(proxied, args);
    }
    /*
        这个程序进入Invoke()内部的无限循环，最终崩溃(发生java.lang.StackOverflow Error)。
        因为上面打印语句会调用toString()方法来打印代理对象；但是，我们通过代理通过接口重定向调用，以及从对象继承的方法调用。
        因此在使用jdk动态代理中尽量不要在invoke方法中使用proxy代理对象，否则很可能会出现上述情况
    */
}
