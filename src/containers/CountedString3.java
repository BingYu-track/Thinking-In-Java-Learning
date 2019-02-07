package containers;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description: hashCode移除了与id的绑定
 * @author: hxw
 * @date: 2019/2/8 2:48
 */
public class CountedString3 {

    private static List<String> created = new ArrayList<String>();
    private String s;
    private int id = 0;
    public CountedString3(String str) {
        s = str;
        created.add(s);
        // id is the total number of instances of this string in use by CountedString3:
        for(String s2 : created)
            if(s2.equals(s))
                id++;
    }

    public String toString() {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }

    public int hashCode() {
        // The very simple approach: return s.hashCode(); Using Joshua Bloch's recipe:
        int result = 17;
        result = 37 * result + s.hashCode();
        // result = 37 * result + id;
        return result;
    }

    public boolean equals(Object o) {
        return o instanceof CountedString3 &&
                s.equals(((CountedString3)o).s) &&
                id == ((CountedString3)o).id;
    }

    /*
    result = 37 * result + id;
    在这一行之前，每个对象都有一个唯一的哈希码。对这一行进行注释后，每个对象生成相同的哈希代码。查找仍然会产生正确的值，
    但是这时每个对象都会散列到同一个桶位。我们必须使用equals()来比较值，直到找到正确的对象时，这样我们就失去了散列的性能优势，
    这个hashCode方法也就失去了意义。
    */
}
