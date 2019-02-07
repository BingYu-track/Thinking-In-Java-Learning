package containers;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 0:25
 */
public class SimpleHashMap3<K,V> extends SimpleHashMap<K,V> {

    @SuppressWarnings("unchecked")
    public void clear() {
        // Effectively erase everything by allocating a new empty array of buckets:通过创建一个新的空桶数组有效地删除所有内容
        buckets = new LinkedList[SIZE];
    }

    public V remove(Object key) {
        // Code is copied from get(), except that before returning the value, the Map.Entry is removed from the list:代码是从get()复制的，但在返回值之前，Map.Entry将从列表中删除：
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return null; //根据key散列后找到链表
        Iterator<MapEntry<K,V>> it = buckets[index].iterator();
        while(it.hasNext()) {
            MapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)) { //遍历链表，根据key找到映射后，删除该映射
                // Changes are here:
                V value = iPair.getValue();
                // Removes the last fetched value:
                it.remove();
                return value;
            }
        }
        return null;
    }


}
