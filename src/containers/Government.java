package containers;

import net.mindview.util.Generator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/20 18:15
 */
class Government implements Generator<String> {

    String[] foundation = ("strange women lying in ponds " + "distributing swords is no basis for a system of " + "government").split(" ");
    private int index;
    public String next() { return foundation[index++]; }
}
