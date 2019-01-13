package arrays;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/13 22:54
 */
public class E19_ArrayEquals {
    public static void main(String[] args) {
        DataHolder[] a1 = new DataHolder[5];
        DataHolder[] a2 = new DataHolder[5];
        Arrays.fill(a1, new DataHolder(1));
        Arrays.fill(a2, new DataHolder(1));
        System.out.println(Arrays.equals(a1, a2)); //false  使用的默认的equal方法，比较的是引用，因此为false
        Arrays.fill(a1, new DataHolderWithEquals(1));
        Arrays.fill(a2, new DataHolderWithEquals(1));
        System.out.println(Arrays.equals(a1, a2)); //true 重写了equal方法，比较的是int属性，因此为true
    }
}
