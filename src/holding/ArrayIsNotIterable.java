package holding;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/4 12:40
 */
public class ArrayIsNotIterable {

    static <T> void test(Iterable<T> ib) {
        for(T t : ib){
            System.out.print(t + " ");
        }
    }
    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = { "A", "B", "C" };
        // 数组可以在foreach工作，但并不代表数组是Iterable
        //! test(strings);
        // You must explicitly convert it to an Iterable:
        test(Arrays.asList(strings));
    }
}
