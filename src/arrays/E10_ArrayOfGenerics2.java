package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/31 23:18
 */
public class E10_ArrayOfGenerics2 {

    public static void main(String[] args) {
        ArrayList<List<String>> ls = new ArrayList<List<String>>();
        ls.add(new ArrayList<String>());
        // Compile-time checking produces an error:
        //! ls.add(new ArrayList<Integer>());
        ls.get(0).add("Array of Generics");
        System.out.println(ls.toString());
    }
}
