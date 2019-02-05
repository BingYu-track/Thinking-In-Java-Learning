package containers;

import java.util.PriorityQueue;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/5 19:09
 */
public class E11_PriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Item> queue = new PriorityQueue<Item>();
        for(int i = 0; i < 10; i++){
            queue.add(new Item());
        }
        Item item;
        while((item = queue.poll()) != null){
            System.out.println(item);
        }
    }

}
