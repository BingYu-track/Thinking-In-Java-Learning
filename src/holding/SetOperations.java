package holding;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @Description:Set集合常用操作
 * @author: hxw
 * @date: 2018/6/19 23:29
 */
public class SetOperations {

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<String>();
        Collections.addAll(set1,"A B C D E F G H I J K L".split(" "));
        set1.add("M");
        System.out.println("H: " + set1.contains("H")); //H: true
        System.out.println("N: " + set1.contains("N")); //N: false
        Set<String> set2 = new HashSet<String>();
        Collections.addAll(set2, "H I J K L".split(" ")); //创建第二个Set集合
        System.out.println("set2 in set1: " + set1.containsAll(set2)); //set2 in set1: true   如果Set包含指定 collection 的所有元素，则返回 true
        set1.remove("H");
        System.out.println("set1: " + set1); //set1: [A, B, C, D, E, F, G, I, J, K, L, M]
        System.out.println("set2 in set1: " + set1.containsAll(set2)); //set2 in set1: false   只要有一个元素不存在，就判断不包含
        set1.removeAll(set2); //移除set1中set1与set2共有的元素
        System.out.println("set2 removed from set1: " + set1); //set2 removed from set1: [A, B, C, D, E, F, G, M]
        Collections.addAll(set1, "X Y Z".split(" "));
        System.out.println("‘X Y Z’ added to set1: " + set1); //‘X Y Z’ added to set1: [A, B, C, D, E, F, G, M, X, Y, Z]
    }
}
