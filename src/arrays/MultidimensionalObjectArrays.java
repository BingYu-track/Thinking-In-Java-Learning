package arrays;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/31 22:12
 */
public class MultidimensionalObjectArrays {

    public static void main(String[] args) {
        BerylliumSphere[][] spheres = {
                { new BerylliumSphere(), new BerylliumSphere() },
                { new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere() },
                { new BerylliumSphere(), new BerylliumSphere(),
                    new BerylliumSphere(), new BerylliumSphere(),
                    new BerylliumSphere(), new BerylliumSphere(),
                    new BerylliumSphere(), new BerylliumSphere() },
        };
        System.out.println(Arrays.deepToString(spheres));
    }
}
