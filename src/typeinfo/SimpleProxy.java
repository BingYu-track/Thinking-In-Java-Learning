package typeinfo;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: 代理设计模式(这种属于静态代理)
 * @author: hxw
 * @date: 2018/9/9 19:50
 */
class SimpleProxy implements Interface {
    private Interface proxied;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }
    public void doSomething() {
        print("SimpleProxy doSomething");
        long start = System.nanoTime();
        proxied.doSomething();
        long duration = System.nanoTime() - start;
        print("METHOD-CALL TIME: " + duration);
    }
    public void somethingElse(String arg) {
        print("SimpleProxy somethingElse " + arg);
        long start = System.nanoTime();
        proxied.somethingElse(arg);
        long duration = System.nanoTime() - start;
        print("METHOD-CALL TIME: " + duration);
    }
}
