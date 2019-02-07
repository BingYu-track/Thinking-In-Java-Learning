package containers;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 1:18
 */
public class SimpleHashMap5<K,V> extends AbstractMap<K,V> {

    static class Entry<K,V> implements Map.Entry<K,V> {
        private K key;
        private V value;
        Entry<K,V> next;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V v) { //修改值并返回旧值
            V result = value;
            value = v;
            return result;
        }

        public int hashCode() {
            return key.hashCode() ^ (value == null ? 0 : value.hashCode()); //key的hashCode与value的hashCode取异或运算
        }

        public boolean equals(Object o) { //对比key和value是否都相同
            if(o instanceof Entry) {
                @SuppressWarnings("unchecked")
                Entry<K,V> e = (Entry<K,V>)o;
                Object key1 = getKey();
                Object key2 = e.getKey();
                if(key1.equals(key2)) {
                    Object val1 = getValue();
                    Object val2 = e.getValue();
                    return val1 == null ? val2 == null : val1.equals(val2);
                }
            }
            return false;
        }

        public String toString() {
            return key + "=" + value;
        }
    }

    static final int SIZE = 997;

    @SuppressWarnings("unchecked")
    Entry<K,V>[] buckets = new Entry[SIZE];

    //待仔细研读
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        Entry<K,V> newPair = new Entry<K,V>(key, value);
        if(buckets[index] == null)
            buckets[index] = newPair;
        Entry<K,V> prevPair = null; // Previous element
        boolean found = false;
        //遍历桶位的Entry，直到下一个结点为null时，说明遍历完成
        for(Entry<K,V> pair = buckets[index] ; pair != null; pair = pair.next) {
            if(pair.getKey().equals(key)) {
                oldValue = pair.getValue();
                // Replace old with new
                if(prevPair != null)
                    prevPair.next = newPair;
                else
                    buckets[index] = newPair; //说明当前节点pair在当前桶位上是头节点
                newPair.next = pair.next;
                found = true;
                break;
            }
            prevPair = pair;
        }

        if(!found)
            prevPair.next = newPair;
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        for(Entry<K,V> pair = buckets[index]; pair != null; pair = pair.next){
            if(pair.getKey().equals(key))
                return pair.getValue();
        }
        return null;
    }

    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<Map.Entry<K,V>>();
        for(Entry<K,V> bucket : buckets) {
            for(Entry<K,V> pair = bucket; pair != null;
                pair = pair.next)
                set.add(pair);
        }
        return set;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        // Effectively erase everything by allocating a new empty array of buckets:
        buckets = new Entry[SIZE];
    }

    public V remove(Object key) {
        // Code is copied from get(), except that before returning the value, the Map.Entry is removed from the "list":
        int index = Math.abs(key.hashCode()) % SIZE;
        Entry<K,V> prevPair = null; // Previous element
        for(Entry<K,V> pair = buckets[index] ; pair != null; pair = pair.next) {
            if(pair.getKey().equals(key)) {
                V value = pair.getValue();
                if(prevPair != null)
                    prevPair.next = pair.next;
                else
                    buckets[index] = null;
                return value;
            }
        }
        return null;
    }

    public int size() {
        // Could rely on the inherited implementation, which returns entrySet().size(), but this is faster:
        int sz = 0;
        for(Entry<K,V> bucket : buckets){
            for(Entry<K,V> pair = bucket; pair != null; pair = pair.next)
                sz++;
        }
        return sz;
    }

    public boolean isEmpty() {
        // Could just say return size() == 0; but this is faster:
        for(Entry<K,V> bucket : buckets){
            if(bucket != null)
                return false;
        }
        return true;
    }

    public boolean containsKey(Object key) {
        // A slight modification of the previous method:
        for(Entry<K,V> bucket : buckets) {
            for(Entry<K,V> pair = bucket; pair != null; pair = pair.next){
                if(pair.getKey().equals(key))
                    return true;
            }
        }
        return false;
    }


}
