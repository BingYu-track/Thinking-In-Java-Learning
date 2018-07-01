package holding;

import java.util.*;

/**
 * @version 1.0
 * @Description: Queue队列
 * @author: hxw
 * @date: 2018/7/1 21:56
 */
public class QueueDemo {

    public static void printQ(Queue queue) {
        while(queue.peek() != null){  //queue.peek() 获取队列的头(但不移除)
            System.out.print(queue.remove() + " "); //queue.remove()获取并移除此队列的头
        }
        System.out.println();
    }

    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<Integer>();
        Random rand = new Random(47);
        for(int i = 0; i < 10; i++){
            queue.offer(rand.nextInt(i + 10)); //将指定的元素插入queue此队列
        }
        printQ(queue);
        Queue<Character> qc = new LinkedList<Character>();
        for(char c : "Brontosaurus".toCharArray()){
            qc.offer(c);
        }
        printQ(qc);
    }
}
