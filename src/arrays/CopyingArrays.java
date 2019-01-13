package arrays;

import java.util.Arrays;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: 数组复制 arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 该方法比for循环快很多
 *  src：源数组
 *  srcPos：从源数组的开始复制的下标
 *  dest：目标数组
 *  destPos：从目标数组的开始复制的下标
 *  length：要复制的长度
 * @author: hxw
 * @date: 2019/1/13 21:23
 */
public class CopyingArrays {

    public static void main(String[] args){
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        print("i = " + Arrays.toString(i)); //[47, 47, 47, 47, 47, 47, 47]
        print("j = " + Arrays.toString(j)); //[99, 99, 99, 99, 99, 99, 99, 99, 99, 99]
        System.arraycopy(i, 0, j, 0, i.length); //从指定源数组i中从下标0开始复制到目标数组j中()
        print("j = " + Arrays.toString(j)); //[47, 47, 47, 47, 47, 47, 47, 99, 99, 99]
        int[] k = new int[5];
        Arrays.fill(k, 103);
        System.arraycopy(i, 0, k, 0, k.length);
        print("k = " + Arrays.toString(k)); //[47, 47, 47, 47, 47]
        Arrays.fill(k, 103);
        System.arraycopy(k, 0, i, 0, k.length);
        print("i = " + Arrays.toString(i)); //[103, 103, 103, 103, 103, 47, 47]
        // Objects:
        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Arrays.fill(u, new Integer(47));
        Arrays.fill(v, new Integer(99));
        print("u = " + Arrays.toString(u)); //[47, 47, 47, 47, 47, 47, 47, 47, 47, 47]
        print("v = " + Arrays.toString(v)); //[99, 99, 99, 99, 99]
        System.arraycopy(v, 0, u, u.length/2, v.length);
        print("u = " + Arrays.toString(u)); //[47, 47, 47, 47, 47, 99, 99, 99, 99, 99]
    }
}
