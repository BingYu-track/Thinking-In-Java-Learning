package holding.exercise;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/3 22:10
 */
public class E28_PriorityQueue {

    static Random rand = new Random(47);

    public static void printQ(Queue<?> queue) {
        for(Object data = queue.poll(); data != null; data = queue.poll()){
            System.out.print(data + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        PriorityQueue<Double> priorityQueue = new PriorityQueue<Double>();
        for(int i = 0; i < 10; i++){
            priorityQueue.offer(rand.nextDouble());
        }
        printQ(priorityQueue);
    }
}
