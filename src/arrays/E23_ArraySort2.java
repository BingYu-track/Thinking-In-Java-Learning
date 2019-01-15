package arrays;

import net.mindview.util.ConvertTo;
import net.mindview.util.Generated;
import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/16 0:06
 */
public class E23_ArraySort2 {

    public static void main(String[] args){
        Generator<Integer> gen = new RandomGenerator.Integer(1000);
        Integer[] a = Generated.array(new Integer[25], gen);
        print("Unsorted array: " + Arrays.toString(a));
        //方法1：
        /*Arrays.sort(a,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                int i = 0;
                if(o1>o2){
                    i = -1;
                }else if(o1<02){
                    i=1;
                }
                return i;
            }
        });*/
        //方法2：
        Arrays.sort(a, Collections.reverseOrder());
        print("Sorted array: " + Arrays.toString(a));
    }
}
