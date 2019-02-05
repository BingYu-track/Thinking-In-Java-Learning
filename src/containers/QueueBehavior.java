package containers;

import net.mindview.util.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/5 17:57
 */
public class QueueBehavior {

    private static int count = 10;

    static <T> void test(Queue<T> queue, Generator<T> gen) {
        for(int i = 0; i < count; i++){
            queue.offer(gen.next());
        }
        while(queue.peek() != null){ //peek()获取但不移除此队列的头
            System.out.print(queue.remove() + " "); //remove()获取并移除此队列的头,返回被移除的元素。
        }
        System.out.println();
    }

    static class Gen implements Generator<String> {
        String[] s = ("one two three four five six seven " + "eight nine ten").split(" ");
        int i;
        public String next() {
            return s[i++];
        }
    }

    public static void main(String[] args) {
        test(new LinkedList<String>(), new Gen());
        test(new PriorityQueue<String>(), new Gen());
        test(new ArrayBlockingQueue<String>(count), new Gen());
        test(new ConcurrentLinkedQueue<String>(), new Gen());
        test(new LinkedBlockingQueue<String>(), new Gen());
        test(new PriorityBlockingQueue<String>(), new Gen());
        //除了优先队列PriorityQueue和PriorityBlockingQueue，其它队列都是按插入的顺序保存的
    }
}
/*
one two three four five six seven eight nine ten
eight five four nine one seven six ten three two
one two three four five six seven eight nine ten
one two three four five six seven eight nine ten
one two three four five six seven eight nine ten
eight five four nine one seven six ten three two
*/
