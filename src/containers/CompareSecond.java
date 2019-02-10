package containers;

import java.util.Comparator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/10 14:36
 */
public class CompareSecond implements Comparator<TwoString> {

    public int compare(TwoString sc1, TwoString sc2) {
        return sc1.s2.compareTo(sc2.s2);
    }
}
