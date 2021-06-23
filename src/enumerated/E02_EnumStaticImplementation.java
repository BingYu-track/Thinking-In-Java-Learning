package enumerated;
import java.util.*;

/**
 * @version 1.0
 * @Description: 习题2
 * @author: bingyu
 * @date: 2021/6/23
 */
public class E02_EnumStaticImplementation {

    public static void printNext() {
        System.out.print(CartoonCharacter.next() + ", ");
    }
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            printNext();
        }
    }
}
