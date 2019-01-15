package arrays;

import net.mindview.util.Generated;

import java.util.Arrays;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/15 8:36
 */
public class ComparatorTest {

    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], CompType.generator());
        print("before sorting:");
        print(Arrays.toString(a));
        Arrays.sort(a, new CompTypeComparator());
        print("after sorting:");
        print(Arrays.toString(a));
    }
}
