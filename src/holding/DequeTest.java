package holding;

import net.mindview.util.Deque;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/5 19:25
 */
public class DequeTest {

    static void fillTest(Deque<Integer> deque) {
        for(int i = 20; i < 27; i++)
            deque.addFirst(i);
        for(int i = 50; i < 55; i++)
            deque.addLast(i);
    }

    public static void main(String[] args) {
        Deque<Integer> di = new Deque<Integer>();
        fillTest(di);
        print(di); //[26, 25, 24, 23, 22, 21, 20, 50, 51, 52, 53, 54]
        while(di.size() != 0){
            printnb(di.removeFirst() + " ");
        }
        print();
        fillTest(di);
        while(di.size() != 0){
            printnb(di.removeLast() + " ");
        }
    }

}
