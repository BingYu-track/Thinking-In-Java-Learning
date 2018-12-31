package arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/31 21:29
 */
public class RaggedArray {

    public static void main(String[] args) {
        Random rand = new Random(47);
        // 3-D array with varied-length vectors:
        int[][][] a = new int[rand.nextInt(7)][][]; // 用随机数确定第一维长度
        System.out.println(Arrays.deepToString(a));
        System.out.println("--------------------------");
        for(int i = 0; i < a.length; i++) {
            a[i] = new int[rand.nextInt(5)][]; //第一层循环定义了第二维长度
            for(int j = 0; j < a[i].length; j++){
                a[i][j] = new int[rand.nextInt(5)]; //第二层循环定义了第三维长度
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
