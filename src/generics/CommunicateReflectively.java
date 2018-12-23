package generics;

import java.lang.reflect.Method;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/23 20:19
 */
class CommunicateReflectively {

    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak = spkr.getMethod("speak");//使用泛型调用speak方法
                speak.invoke(speaker);
            } catch(NoSuchMethodException e) {
                print(speaker + " cannot speak");
            }

            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch(NoSuchMethodException e) {
                print(speaker + " cannot sit");
            }

        } catch(Exception e) {
            throw new RuntimeException(speaker.toString(), e);
        }
    }
}
