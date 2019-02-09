package containers;

import java.util.Comparator;

/**
 * @version 1.0
 * @Description: MapEntry<K,V>比较器
 * @author: hxw
 * @date: 2019/2/9 22:02
 */
public class MapEntryComp<K,V> implements Comparator<MapEntry<K,V>> {

    public int compare(MapEntry<K,V> o1, MapEntry<K,V> o2) { //对键key进行比较
        Comparable<K> c1 = (Comparable<K>)o1.getKey();
        return c1.compareTo(o2.getKey());
    }
}
