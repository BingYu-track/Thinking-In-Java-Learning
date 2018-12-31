package arrays;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/31 20:36
 */
public class E02_ReturningArray {

    static BerylliumSphere[] createArray(int size) {
        BerylliumSphere[] a = new BerylliumSphere[size];
        for(int i = 0; i < size; i++){
            a[i] = new BerylliumSphere();
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createArray(10)));
    }
}
