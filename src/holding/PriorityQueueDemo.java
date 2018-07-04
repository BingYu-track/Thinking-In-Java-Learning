package holding;

import java.util.*;

/**
 * @version 1.0
 * @Description: 优先队列
 * @author: hxw
 * @date: 2018/7/2 13:19
 */
public class PriorityQueueDemo {
    /**
     * 注意：优先级队列的元素按照其自然顺序进行排序，或者根据构造队列时提供的 Comparator 进行排序，具体取决于所使用的构造方法。
     * 优先级队列不允许使用 null 元素。依靠自然顺序的优先级队列还不允许插入不可比较的对象
     * @param args
     */

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Random rand = new Random(47);
        for(int i = 0; i < 10; i++){
            priorityQueue.offer(rand.nextInt(i + 10)); //将指定的元素插入此优先级队列，此时数字在优先级队列中会自动排序(根据二叉树原理进行排序)
        }
        System.out.println("初始化："+priorityQueue); //[0, 1, 1, 1, 1, 14, 3, 8, 1, 5] 注意这里的顺序不是
        QueueDemo.printQ(priorityQueue); //0 1 1 1 1 1 3 5 8 14   注意：PriorityQueue每次从队列中取出的是具有最高优先权限的元素
        List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<Integer>(ints);
        System.out.println("初始化："+priorityQueue); //[1, 1, 3, 18, 2, 9, 18, 23, 22, 14, 3, 9, 14, 20, 21, 25, 25]
        QueueDemo.printQ(priorityQueue);
        priorityQueue = new PriorityQueue<Integer>( ints.size(), Collections.reverseOrder());  //Collections.reverseOrder()返回一个比较器，它强行逆转实现了 Comparable 接口的对象 collection 的自然顺序
        priorityQueue.addAll(ints);  //此时内部比较器发生了改变
        System.out.println("比较规则改变："+priorityQueue); //[25, 25, 21, 23, 14, 14, 20, 22, 1, 2, 3, 9, 9, 3, 18, 1, 18]
        QueueDemo.printQ(priorityQueue); //25 25 23 22 21 20 18 18 14 14 9 9 3 3 2 1 1
        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ = new PriorityQueue<String>(strings);
        QueueDemo.printQ(stringPQ);
        stringPQ = new PriorityQueue<String>( strings.size(), Collections.reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.printQ(stringPQ);
        Set<Character> charSet = new HashSet<Character>();
        for(char c : fact.toCharArray()){
            charSet.add(c); // 由于使用了Set过滤掉了重复字母
        }
        PriorityQueue<Character> characterPQ = new PriorityQueue<Character>(charSet);
        QueueDemo.printQ(characterPQ);
    }
}
