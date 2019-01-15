package arrays;

import net.mindview.util.Generated;

import java.util.Arrays;
import java.util.Collections;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:  Collections.reverseOrder()方法反转自然顺序
 * @author: hxw
 * @date: 2019/1/15 8:13
 */
public class Reverse {

    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], CompType.generator());
        print("before sorting:");
        print(Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder()); //注意Arrays.sort方法传入的参数数组中的所有元素都必须实现 Comparable 接口
        print("after sorting:");
        print(Arrays.toString(a));
    }
}
