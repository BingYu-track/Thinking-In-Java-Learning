package arrays;

import net.mindview.util.ConvertTo;
import net.mindview.util.Generated;
import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;
import static net.mindview.util.Print.*;
import java.util.Arrays;

/**
 * @version 1.0
 * @Description: Arrays.binarySearch(int[] a, int key)方法 ，返回值如果等于或大于0，说明找到目标；
 *  否则产生负数(负数计算方式：-(插入点)-1 )
 *  插入点：第一个大于查找元素所在的数组的位置
 * @author: hxw
 * @date: 2019/1/15 23:10
 */
public class ArraySearching {

    public static void main(String[] args) {
        //获取0~1000的随机数生成器
        Generator<Integer> gen = new RandomGenerator.Integer(1000);
        Integer[] ai = Generated.array(new Integer[25], gen);
        int[] a = ConvertTo.primitive(ai); //将包装类Integer数组转化为int原始类型数组
        Arrays.sort(a);
        print("Sorted array: " + Arrays.toString(a));
        while(true) {
            int r = gen.next(); //随机生成数r
            int location = Arrays.binarySearch(a, r); //向排好序的数组a查找随机数r在数组a的位置
            if(location >= 0) {
                print("Location of " + r + " is " + location + ", a[" + location + "] = " + a[location]);
                break; // Out of while loop
            }
        }
    }

}
