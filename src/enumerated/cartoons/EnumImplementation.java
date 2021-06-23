package enumerated.cartoons;
import net.mindview.util.*;
/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/23
 */
public class EnumImplementation {

    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ", ");
    }
    public static void main(String[] args) {
        // Choose any instance:
        CartoonCharacter cc = CartoonCharacter.BOB;
        for(int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}
