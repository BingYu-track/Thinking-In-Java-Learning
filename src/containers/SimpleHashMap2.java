package containers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 0:13
 */
public class SimpleHashMap2<K,V> extends SimpleHashMap<K,V> {

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        if (buckets[index] == null){
            buckets[index] = new LinkedList<MapEntry<K, V>>();
            // Lines added here:
        } else { //这里增加了
            System.out.println("Collision while adding\n" + pair + "\nBucket already contains:");
            Iterator<MapEntry<K, V>> it = buckets[index].iterator();
            while (it.hasNext())
                System.out.println(it.next());
        }
        // End of lines added
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();

        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                found = true;
                break;
            }
        }

        if(!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }


    public V get(Object key) {
        int count = 0;
        int index = Math.abs(key.hashCode()) % SIZE; //同样用上面的算法获取散列值
        if(buckets[index] == null) return null;
        for(MapEntry<K,V> iPair : buckets[index]){ //遍历该桶位的链表，查找链表里的元素值
            count++;
            if(iPair.getKey().equals(key))
                System.out.println("key:"+key+" 查找次数：" +count);
                return iPair.getValue();
        }
        return null;
    }
}
