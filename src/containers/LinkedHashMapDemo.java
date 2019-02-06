package containers;

import java.util.LinkedHashMap;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description: LinkedHashMap
 * @author: hxw
 * @date: 2019/2/6 18:19
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedMap = new LinkedHashMap<Integer,String>(new CountingMapData(9));
        print(linkedMap);
        // Least-recently-used order: 最近使用最少算法LRU
        linkedMap = new LinkedHashMap<Integer,String>(16, 0.75f, true); //这里排序模式accessOrder必须为true才会开启LRU
        linkedMap.putAll(new CountingMapData(9));
        print(linkedMap);
        for(int i = 0; i < 6; i++) // Cause accesses:
            linkedMap.get(i);
        print(linkedMap);
        linkedMap.get(0);
        print(linkedMap);
    }
    /*
        在使用LRU后，我们for循环只访问了前6个元素，发现最后3个元素移到了前面，我们再一次访问0时，它就被移到到最后面了
     */
}
