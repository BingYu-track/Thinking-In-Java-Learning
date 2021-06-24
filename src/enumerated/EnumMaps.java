package enumerated;
import java.util.*;
import static enumerated.AlarmPoints.*;
import static net.mindview.util.Print.*;
interface Command { void action(); }  //映入
/**
 * @version 1.0
 * @Description: EnumMap
 * @author: bingyu
 * @date: 2021/6/24
 */
public class EnumMaps {

    public static void main(String[] args) {
        EnumMap<AlarmPoints,Command> em = new EnumMap<AlarmPoints,Command>(AlarmPoints.class);

        em.put(KITCHEN, new Command() {
            public void action() { print("Kitchen fire!"); }
        });

        em.put(BATHROOM, new Command() {
            public void action() { print("Bathroom alert!"); }
        });

        for(Map.Entry<AlarmPoints,Command> e : em.entrySet()) {
            printnb(e.getKey() + ": ");
            e.getValue().action(); //调用Command接口的action方法
        }

        try { // If there’s no value for a particular key:
            em.get(UTILITY).action();
        } catch(Exception e) {
            print(e);
        }
    }

}
