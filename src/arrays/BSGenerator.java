package arrays;

import net.mindview.util.Generator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/15 8:53
 */
public class BSGenerator implements Generator<BerylliumSphere> {

    public BerylliumSphere next() {
        return new BerylliumSphere();
    }
}
