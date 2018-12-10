package generics;

import net.mindview.util.RandomGenerator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/10 23:56
 */
public class PrimitiveGenericTest {

    public static void main(String[] args) {
        String[] strings = FArray.fill(new String[7], new RandomGenerator.String(10));
        for(String s : strings){
            System.out.println(s);
        }

        Integer[] integers = FArray.fill(new Integer[7], new RandomGenerator.Integer());
        for(int i: integers){
            System.out.println(i);
        }
        // Autoboxing won’t save you here. This won’t compile:
        // int[] b = FArray.fill(new int[7], new RandomGenerator.Integer());
    }
}
