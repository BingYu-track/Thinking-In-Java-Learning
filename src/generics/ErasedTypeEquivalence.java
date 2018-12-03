package generics;

import java.util.ArrayList;

/**
 * @version 1.0
 * @Description: 泛型擦除初例
 * @author: hxw
 * @date: 2018/10/7 12:30
 */
public class ErasedTypeEquivalence {

    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2); //true
    }
}
