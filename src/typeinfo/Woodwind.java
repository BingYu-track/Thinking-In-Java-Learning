package typeinfo;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: 木管乐器
 * @author: hxw
 * @date: 2018/9/19 21:28
 */
public class Woodwind extends Wind {
    public void play() { print("Woodwind.play()"); }
    public String what() { return "Woodwind"; }
    public void clearSpitValve() {
        print("Woodwind.clearSpitValve");
    }
}
