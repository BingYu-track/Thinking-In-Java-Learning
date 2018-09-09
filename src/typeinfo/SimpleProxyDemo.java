package typeinfo;

/**
 * @version 1.0
 * @Description: 静态代理
 * @author: hxw
 * @date: 2018/9/9 19:51
 */
class SimpleProxyDemo {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
