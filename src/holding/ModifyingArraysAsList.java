package holding;

import java.util.*;

/**
 * @version 1.0
 * @Description: 直接打乱用Arrays.asList数组生成的List会改变底层的数组
 * @author: hxw
 * @date: 2018/7/5 13:01
 */
public class ModifyingArraysAsList {

    public static void main(String[] args){
        Random rand = new Random(47);
        Integer[] ia = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(ia));
        System.out.println("Before shuffling: " + list1);
        Collections.shuffle(list1, rand);
        System.out.println("After shuffling: " + list1);
        System.out.println("array: " + Arrays.toString(ia));
        List<Integer> list2 = Arrays.asList(ia);
        System.out.println("Before shuffling: " + list2);
        Collections.shuffle(list2, rand);
        System.out.println("After shuffling: " + list2);
        System.out.println("array: " + Arrays.toString(ia)); //ia数组发生了改变
    }
}
