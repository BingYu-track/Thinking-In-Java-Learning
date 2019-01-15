package arrays;

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;
import static net.mindview.util.Print.*;
import java.util.Arrays;
import java.util.Collections;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/15 9:05
 */
public class StringSorting {

    public static void main(String[] args) {
        String[] sa = Generated.array(new String[20], new RandomGenerator.String(5));
        print("Before sort: " + Arrays.toString(sa));
        Arrays.sort(sa);
        print("After sort: " + Arrays.toString(sa));
        Arrays.sort(sa, Collections.reverseOrder());
        print("Reverse sort: " + Arrays.toString(sa));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER); //忽略大小写字母排序
        print("Case-insensitive sort: " + Arrays.toString(sa));
    }
}
