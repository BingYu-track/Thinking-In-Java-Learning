package holding.exercise;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/1 22:17
 */
public class Producer {

    public static void produce(Queue<Command> q) {
        q.offer(new Command("load"));
        q.offer(new Command("delete"));
        q.offer(new Command("save"));
        q.offer(new Command("exit"));
    }
}
