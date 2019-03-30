package holding;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @version 1.0
 * @Description: 迭代器的fail-fast机制
 * @author: hxw
 * @date: 2019/3/28 17:48
 */
public class FailFastTest {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println(list);
        Iterator<Integer> iterator = list.iterator();
        list.add(10);
        iterator.hasNext();
        while (iterator.hasNext()){
            Integer next = iterator.next(); //这里抛出java.util.ConcurrentModificationException，这是因为初始化迭代器时
            // int expectedModCount = modCount已经确定了，后面再添加和删除元素会导致modCount自增，而每次迭代器调用next方法时会比较modCount是否与expectedModCount相同，否则报错，
            //这么做的目的是保证在用迭代器遍历元素之前，List里元素没有被更改过。
            System.out.print(next);
        }
    }
}
