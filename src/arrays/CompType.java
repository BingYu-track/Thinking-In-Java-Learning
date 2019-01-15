package arrays;

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import static net.mindview.util.Print.*;
import java.util.Arrays;
import java.util.Random;

/**
 * @version 1.0
 * @Description:
 * @author: hxw7
 * @date: 2019/1/15 8:00
 */
public class CompType implements Comparable<CompType>{

    int i;
    int j;
    private static int count = 1;
    public CompType(int n1, int n2) {
        i = n1;
        j = n2;
    }

    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if(count++ % 3 == 0){
            result += "\n";
        }
        return result;
    }

    public int compareTo(CompType rv) {
        return (i < rv.i ? -1 : (i == rv.i ? 0 : 1));
    }

    private static Random r = new Random(47);

    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            public CompType next() {
                return new CompType(r.nextInt(100),r.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], generator());
        print("before sorting:");
        print(Arrays.toString(a));
        Arrays.sort(a);
        print("after sorting:");
        print(Arrays.toString(a));
    }
}
