package enumerated;
import static net.mindview.util.Print.*;
// Define an enum type:
enum Signal { GREEN, YELLOW, RED, }
/**
 * @version 1.0
 * @Description: 枚举与switch一起使用
 * @author: bingyu
 * @date: 2021/6/21
 */
public class TrafficLight {
    Signal color = Signal.RED;
    public void change() { //红绿灯变化的简单实现
        switch(color) {
            // Note that you don’t have to say Signal.RED
            // in the case statement:
            case RED: color = Signal.GREEN;
                break;
            case GREEN: color = Signal.YELLOW;
                break;
            case YELLOW: color = Signal.RED;
                break;
        }
    }

    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for(int i = 0; i < 7; i++) {
            print(t);
            t.change();
        }
    }

}
