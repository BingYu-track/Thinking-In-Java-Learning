package holding.exercise;

import java.util.PriorityQueue;

/**
 * @version 1.0
 * @Description: 证明不允许插入不可比较的对象
 * @author: hxw
 * @date: 2018/7/3 22:17
 */
public class E29_PriorityQueueSubtlety {

    public static void main(String[] args) {
        PriorityQueue<Dummy> priorityQueue = new PriorityQueue<Dummy>();
        System.out.println("Adding 1st instance...");
        priorityQueue.offer(new Dummy());
        System.out.println("Adding 2nd instance...");
        priorityQueue.offer(new Dummy());
    }
}
