package typeinfo;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: 动态代理设计模式
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
        proxied.doSomething();
    }
    public void somethingElse(String arg) {
        print("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}
