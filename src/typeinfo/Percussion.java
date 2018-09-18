package typeinfo;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: 打击乐器
 * @author: hxw
 * @date: 2018/9/18 22:46
 */
class Percussion implements Instrument {

    public void play() { print("Percussion.play()"); }
    public String what() { return "Percussion"; }
    public void adjust() {}
    public void prepareInstrument() {
        print("Percussion.prepareInstrument");
    }
}
