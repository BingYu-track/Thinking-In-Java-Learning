package generics;
import generics.watercolors.Watercolors;

import java.util.*;
import static net.mindview.util.Print.*;
import static net.mindview.util.Sets.*;
import static generics.watercolors.Watercolors.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/6 17:17
 */
public class WatercolorSets {

    public static void main(String[] args) {
        //注意这里使用了EnumSet(专为枚举类使用的集合)，用来从枚举直接创建Set
        //range()方法--创建一个最初包含由两个指定端点所定义范围内的所有元素的枚举 set
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        print("set1: " + set1);
        print("set2: " + set2);
        //并集
        print("union(set1, set2): " + union(set1, set2));
        //交集
        Set<Watercolors> subset = intersection(set1, set2);
        print("intersection(set1, set2): " + subset);
        //差集
        print("difference(set1, subset): " + difference(set1, subset));
        print("difference(set2, subset): " + difference(set2, subset));
        //补集
        print("complement(set1, set2): " + complement(set1, set2));
    }
}
