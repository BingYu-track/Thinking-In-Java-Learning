package typeinfo;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: 铜管乐器
 * @author: hxw
 * @date: 2018/9/18 22:47
 */
class Brass extends Wind {
    public void play() { print("Brass.play()"); }
    public void adjust() { print("Brass.adjust()"); }
    public void clearSpitValve() {
        print("Brass.clearSpitValve");
    }
}
