package operators;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/3/21 23:42
 */
public class BitCalculate {

    @Test
    public void test(){
        for(int i=1;i<=100;i++){
            if((i & 1)==0){
                System.out.println(i+" 是偶数");
            }
            if((i & 1)==1){
                System.out.println(i+" 奇数");
            }
        }
    }

    @Test
    public void test1(){
       /* System.out.println(1 << 30); // 1073741824
        System.out.println(1 << 4); //16
        System.out.println(4 & 3); //0
        System.out.println(5 & 4); //4
        System.out.println(6 & 5); //4
        System.out.println(7 & 6); //6
        System.out.println();*/
        HashMap<Integer, String> map = new HashMap<>();//
        map.put(1,"a");
        System.out.println(map);
    }

    public static void main(String[] args){
        /*HashMap<Integer, String> map = new HashMap<>();//
        map.put(1,"a");
        map.put(1,"b");
        map.put(2,"c");
        System.out.println(map);
        new ConcurrentHashMap();*/
        Node[] nodes = new Node[10];
        Node p = new Node(1,new Node(2));
        Node next = p.next;
        p.next = nodes[0];
        nodes[0] = p;
        p = next;
    }
}
