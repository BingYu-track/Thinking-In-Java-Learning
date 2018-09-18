package typeinfo;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: 有弦（乐器）
 * @author: hxw
 * @date: 2018/9/18 22:47
 */
class Stringed implements Instrument {

    public void play() { print("Stringed.play()"); }
    public String what() { return "Stringed"; }
    public void adjust() {}
    public void prepareInstrument() {
        print("Stringed.prepareInstrument");
    }
}
