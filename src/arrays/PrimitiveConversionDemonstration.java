package arrays;

import net.mindview.util.ConvertTo;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/5 22:35
 */
public class PrimitiveConversionDemonstration {

    public static void main(String[] args) {
        Integer[] a = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        int[] b = ConvertTo.primitive(a);
        System.out.println(Arrays.toString(b));
        boolean[] c = ConvertTo.primitive(
                        Generated.array(Boolean.class, new CountingGenerator.Boolean(), 7)
        );
        System.out.println(Arrays.toString(c));
    }
}
