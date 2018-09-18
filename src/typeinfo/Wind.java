package typeinfo;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: 管乐器
 * @author: hxw
 * @date: 2018/9/18 22:45
 */
class Wind implements Instrument {

    public void play() { print("Wind.play()"); }
    public String what() { return "Wind"; }
    public void adjust() {}
    //清理口水
    public void clearSpitValve() {
        print("Wind.clearSpitValve");
    }
    public void prepareInstrument() {
        clearSpitValve();
    }
}
