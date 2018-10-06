package generics;

import generics.watercolors.*;
import java.util.*;
import static net.mindview.util.Print.*;
import static generics.watercolors.Watercolors.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/6 18:12
 */
public class E17_Sets2 {

    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        print("set1: " + set1);
        print("set2: " + set2);
        print("union(set1, set2): " + Sets2.union(set1, set2));
        print("union(set1, set2) type: " + Sets2.union(set1, set2).getClass().getSimpleName());
        Set<Integer> set3 = new HashSet<Integer>();
        set3.add(1);
        Set<Integer> set4 = new HashSet<Integer>();
        set4.add(2);
        print("set3: " + set3);
        print("set4: " + set4);
        print("union(set3, set4): " + Sets2.union(set3, set4));
        print("union(set3, set4) type: " + Sets2.union(set3, set4).getClass().getSimpleName());
    }
}
