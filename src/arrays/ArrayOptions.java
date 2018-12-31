package arrays;

import java.util.Arrays;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/31 16:01
 */
public class ArrayOptions {

    //注意：length只表示数组能够容纳多少元素，而不是实际保存元素的个数
    public static void main(String[] args){
        // Arrays of objects:
        BerylliumSphere[] a; // Local uninitialized variable 未初始化的局部变量
        BerylliumSphere[] b = new BerylliumSphere[5];
        // The references inside the array are automatically initialized to null: 数组中的引用被自动初始化为null
        print("b: " + Arrays.toString(b));
        BerylliumSphere[] c = new BerylliumSphere[4];
        for(int i = 0; i < c.length; i++){
            if(c[i] == null) { // Can test for null reference
                c[i] = new BerylliumSphere();
            }
        }
        // Aggregate initialization: 聚合初始化
        BerylliumSphere[] d = { new BerylliumSphere(),
                new BerylliumSphere(), new BerylliumSphere()
        };
        // Dynamic aggregate initialization: 动态聚合初始化
        a = new BerylliumSphere[]{
                new BerylliumSphere(), new BerylliumSphere(),
        };
        // (Trailing comma is optional in both cases)
        print("a.length = " + a.length);
        print("b.length = " + b.length);
        print("c.length = " + c.length);
        print("d.length = " + d.length);
        a = d;
        print("a.length = " + a.length);
        // Arrays of primitives:
        int[] e; // Null reference
        int[] f = new int[5];
        // The primitives inside the array are automatically initialized to zero:
        print("f: " + Arrays.toString(f));
        int[] g = new int[4];
        for(int i = 0; i < g.length; i++){
            g[i] = i*i;
        }
        int[] h = { 11, 47, 93 };
        // Compile error: variable e not initialized: 变量e还未初始化
        //!print("e.length = " + e.length);
        print("f.length = " + f.length);
        print("g.length = " + g.length);
        print("h.length = " + h.length);
        e = h;
        print("e.length = " + e.length);
        e = new int[]{ 1, 2 };
        print("e.length = " + e.length);
    }
}
