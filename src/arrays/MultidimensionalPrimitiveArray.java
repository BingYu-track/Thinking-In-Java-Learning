package arrays;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description: 多维数组
 * @author: hxw
 * @date: 2018/12/31 20:42
 */
public class MultidimensionalPrimitiveArray {

    public static void main(String[] args) {
        int[][] a = {
                { 1, 2, 3, },
                { 4, 5, 6, },
        };
        System.out.println(Arrays.deepToString(a)); //返回指定数组“深层内容”的字符串表示形式，因为直接打印数组显示的是hash值
    }
}
