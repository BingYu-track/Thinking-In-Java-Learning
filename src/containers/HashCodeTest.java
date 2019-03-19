package containers;

import org.junit.Test;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/3/7 12:34
 */
public class HashCodeTest {

    public static void main(String[] args) {
        Collection set = new HashSet();
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);

        System.out.println(p1.equals(p2)); //true
        set.add(p1);   //(1)
        set.add(p2);   //(2)
        set.add(p1);   //(3)

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println(object+ " hashCode: "+ object.hashCode());
        }
        /*
        输出结果：
        x:1,y:1 hashCode: 1735600054
        x:1,y:1 hashCode: 356573597
        可以看出只重写了equals，没有重写hashCode，equals方法相同，并不能说明hashCode相同
        */
    }

    @Test
    public void test(){
        List<Object> list = new ArrayList<>();
        long round = Math.round(-3.6);
        System.out.println(round); //-1
    }

    //字符串测试
    @Test
    public void test1(){
        String str1 = "i";
        String str2 = "i";
        String str3 = new String("i");
        String str4 = new String("i");
        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str3==str4);
    }
}
