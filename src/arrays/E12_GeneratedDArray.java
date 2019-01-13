package arrays;

import net.mindview.util.ConvertTo;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/13 21:15
 */
public class E12_GeneratedDArray {

    public static void main(String[] args) {
        double[] d = ConvertTo.primitive(Generated.array(Double.class, new CountingGenerator.Double(), 15));
        System.out.println(Arrays.toString(d));
    }
}
