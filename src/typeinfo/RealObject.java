package typeinfo;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: jdk动态代理
 * @author: hxw
 * @date: 2018/9/9 19:49
 */
class RealObject implements Interface {
    public void doSomething() { print("doSomething"); }
    public void somethingElse(String arg) {
        print("somethingElse " + arg);
    }
}
