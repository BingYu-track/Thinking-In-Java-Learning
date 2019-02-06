package containers;

import java.util.Iterator;
import java.util.TreeMap;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description: TreeMap
 * @author: hxw
 * @date: 2019/2/6 18:11
 */
public class SortedMapDemo {

    public static void main(String[] args) {
        TreeMap<Integer,String> sortedMap = new TreeMap<Integer,String>(new CountingMapData(10));
        print(sortedMap);
        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        print(low);
        print(high);
        Iterator<Integer> it = sortedMap.keySet().iterator();
        for(int i = 0; i <= 6; i++) {
            if(i == 3)
                low = it.next();
            if(i == 6)
                high = it.next();
            else it.next();
        }
        print(low);
        print(high);
        print(sortedMap.subMap(low, high));
        print(sortedMap.headMap(high));
        print(sortedMap.tailMap(low));
    }
}
