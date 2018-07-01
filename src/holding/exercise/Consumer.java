package holding.exercise;
import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/1 22:18
 */
public class Consumer {

    public static void consume(Queue<Command> q) {
        while(q.peek() != null){
            q.remove().operation();
        }
    }
}
