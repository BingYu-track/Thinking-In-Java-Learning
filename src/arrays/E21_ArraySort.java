package arrays;

import net.mindview.util.Generated;
import static net.mindview.util.Print.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/15 8:50
 */
public class E21_ArraySort {

    public static void main(String[] args){
        Random r = new Random(47);
        BerylliumSphere[] a = Generated.array(BerylliumSphere.class, new BSGenerator(), 5);
        Collections.shuffle(Arrays.asList(a), r);
        print("Before sort 1: a = " + Arrays.toString(a));
        try {
            Arrays.sort(a);
            print("After sort 1: a = " + Arrays.toString(a));
        } catch(ClassCastException e) {
            System.out.println("Array cannot be sorted!");
        }
        for(int i = 0; i < a.length; i++){
            a[i] = new ComparableBerylliumSphere();
        }
        Collections.shuffle(Arrays.asList(a), r);
        print("Before sort 2: a = " + Arrays.toString(a));
        Arrays.sort(a);
        print("After sort 2: a = " + Arrays.toString(a));
        Collections.shuffle(Arrays.asList(a), r);
        print("Before rev. sort 3: a = " + Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        print("After rev. sort 3: a = " + Arrays.toString(a));
    }
}
