package holding.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/1 22:16
 */
public class E27_CommandQueue {

    public static void main(String[] args) {
        Queue<Command> cmds = new LinkedList<Command>();
        Producer.produce(cmds); //产生命令
        Consumer.consume(cmds); //消费命令
    }
}
