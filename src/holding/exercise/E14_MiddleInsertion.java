package holding.exercise;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @version 1.0
 * @Description: 使用LinkedList通过使用ListIterator将若干个数字插入，并且要总是插入到中间
 * @author: hxw
 * @date: 2018/6/19 17:55
 */
public class E14_MiddleInsertion {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        ListIterator<Integer> it = list.listIterator();
        for(int i = 1; i <= 10; i++) {
            it.add(i);
            if(i % 2 == 0)
                it.previous(); //当为偶数时，使用previous()方法让游标移动到中间位置
        }
        System.out.println(list);
    }
}
