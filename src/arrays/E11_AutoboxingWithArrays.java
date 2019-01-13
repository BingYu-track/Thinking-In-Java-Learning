package arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/5 22:46
 */
public class E11_AutoboxingWithArrays {

    public static void main(String[] args) {
        int[] pa = { 1, 2, 3, 4, 5 };
        // Integer[] wa = pa; 报错
        Integer[] wb = { 1, 2, 3, 4, 5 };
        // int[] pb = wb; 自动包装不能直接应用于数组
    }
}
