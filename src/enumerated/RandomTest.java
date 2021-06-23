package enumerated;
import net.mindview.util.*;
enum Activity { SITTING, LYING, STANDING, HOPPING,
    RUNNING, DODGING, JUMPING, FALLING, FLYING }
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/23
 */
public class RandomTest {

    public static void main(String[] args) {
        for(int i = 0; i < 20; i++) {
            System.out.print(Enums.random(Activity.class) + " ");
        }
    }
}
