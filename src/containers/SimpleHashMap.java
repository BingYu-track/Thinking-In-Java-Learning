package containers;

import net.mindview.util.Countries;

import java.util.*;

/**
 * @version 1.0
 * @Description: 简单的散列表实现(需要具备基本的散列表数据结构知识)
 * @author: hxw
 * @date: 2019/2/7 21:02
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {

    // Choose a prime number for the hash table size, to achieve a uniform distribution: 为哈希表大小选择素数，以实现均匀分布
    static final int SIZE = 997;
    // You can’t have a physical array of generics,but you can upcast to one: 您不能有一个真正的泛型数组，但您可以向上转换为一个
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE]; //实际散列表表中的数组，一个链表数组(也叫"桶位")

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE; //本例的散列算法： 通过key的hashCode的绝对值对数组SIZE长度取余获取的散列
        if(buckets[index] == null){
            buckets[index] = new LinkedList<MapEntry<K,V>>(); //如果计算好的散列所对应的数组位置没有元素，则在该桶位创建一个链表
        }
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<K,V>(key, value); //这里为什么要新创建一个映射？
        boolean found = false; //元素是否查找到的标志
        ListIterator<MapEntry<K,V>> it = bucket.listIterator(); //获取该桶位链表的迭代器
        while(it.hasNext()) { //遍历桶位的链表
            MapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)) { //一旦发现key相同，则将新的值更新到里面
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                found = true;
                break;
            }
        }
        if(!found){  //第一次创建的桶位肯定是没有元素的，因此将上面新创建的映射pair添加到该桶位的链表中
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE; //同样用上面的算法获取散列值
        if(buckets[index] == null) return null;
        for(MapEntry<K,V> iPair : buckets[index]){ //遍历该桶位的链表，查找链表里的元素值
            if(iPair.getKey().equals(key))
                return iPair.getValue();
        }
        return null;
    }

    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
        for(LinkedList<MapEntry<K,V>> bucket : buckets) { //遍历数组里所有的链表，将其所有的元素添加到st里
            if(bucket == null) continue;
            for(MapEntry<K,V> mpair : bucket) //
                set.add(mpair);
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String,String> m = new SimpleHashMap<String,String>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());
    }
}
