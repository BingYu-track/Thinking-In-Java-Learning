package arrays;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description: 三维数组
 * @author: hxw
 * @date: 2018/12/31 21:27
 */
public class ThreeDWithNew {

    public static void main(String[] args) {
        // 3-D array with fixed length:
        int[][][] a = new int[2][2][4];
        System.out.println(Arrays.deepToString(a));
    }
}
