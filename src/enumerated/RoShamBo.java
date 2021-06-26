package enumerated;
import net.mindview.util.*;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/26
 */
public class RoShamBo {

    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }

    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for(int i = 0; i < size; i++) {
            T randomA = Enums.random(rsbClass);
            T randomB = Enums.random(rsbClass);
            match(randomA,randomB);
        }

    }
}
