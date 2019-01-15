package arrays;

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description: binarySearch(T[] a, T key, Comparator<? super T> c)
 * @author: hxw
 * @date: 2019/1/15 23:43
 */
public class AlphabeticSearch {

    public static void main(String[] args) {
        String[] sa = Generated.array(new String[30], new RandomGenerator.String(5));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER); //这里在对数组sa排序时用的是String.CASE_INSENSITIVE_ORDERComparator接口，因此下次二分法排序时也必须用这个接口查找
        System.out.println(Arrays.toString(sa));
        int index = Arrays.binarySearch(sa, sa[10], String.CASE_INSENSITIVE_ORDER); //注意：String.CASE_INSENSITIVE_ORDER就是一个Comparator接口
        System.out.println("Index: "+ index + "\n"+ sa[index]);
    }
}
