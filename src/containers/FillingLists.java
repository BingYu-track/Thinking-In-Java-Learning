package containers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @version 1.0
 * @Description: Collections.nCopies(int n, T o) 方法 --返回由指定对象的 n 个副本组成的不可变列表。
 * @author: hxw
 * @date: 2019/1/17 0:08
 */
public class FillingLists {
    public static void main(String[] args) {
        StringAddress hello = new StringAddress("Hello");
        List<StringAddress> stringAddresses = Collections.nCopies(4, hello); //同样是填充的引用
        List<StringAddress> list= new ArrayList<StringAddress>(stringAddresses);
        System.out.println(list);
        Collections.fill(list, new StringAddress("World!")); //填充引用
        System.out.println(list);
    }

}
