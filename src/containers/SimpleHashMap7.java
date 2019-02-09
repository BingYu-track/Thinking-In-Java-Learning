package containers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

/**
 * @version 1.0
 * @Description: hashMap扩容实现
 * @author: hxw
 * @date: 2019/2/10 0:02
 */
@SuppressWarnings("unchecked")
public class SimpleHashMap7<K,V> extends SimpleHashMap<K,V> {

    private int count; // Number of elements 元素数量
    private static final double loadFactor = 0.75; //负载因子
    // Use a prime initial capacity; the JDK uses a number, which is a power of 2: 我们使用质数11初始化容量；jdk使用的是2的幂次方。
    private final static int initialCapacity = 11;
    private int capacity = initialCapacity;
    private int threshold = (int)(capacity * loadFactor); //阈值


    {
        buckets = new LinkedList[capacity]; //再创建对象之前创建一个和初始容量一样的桶位列表(这才是真正的容量)
    }

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % capacity;
        if(buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K,V>>();
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while(it.hasNext()) {
            MapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                found = true;
                break;
            }
        }
        if(!found) { //相比父类，主要是这段代码改变了
            if(count >= threshold) //如果元素数量大于等于阈值就再次散列
                rehash();
            if(buckets[index] == null) //当此时put可能是阈值，前面会再次散列了，可能导致之前的桶位buckets[index] == null，因此需要这段代码
                buckets[index] = new LinkedList<MapEntry<K,V>>();
            buckets[index].add(pair);
            ++count;
        }
        return oldValue;
    }

    /**
     * 判断是否是素数
     * @param candidate
     * @return
     */
    private boolean isPrime(int candidate) {
        for(int j = 2; j < candidate; j++){
            if(candidate % j == 0)
                return false;
        }
        return true;
    }

    /**
     * 获取下一个素数
     * @param candidate
     * @return
     */
    private int nextPrime(int candidate) {
        while(!isPrime(candidate)){ //不是素数，就一直自增，直到为素数为止
            candidate++;
        }
        return candidate;
    }

    //再散列
    private void rehash() {
        // Points to a new Set of the entries, so it won't be bothered by what we're about to do: 使用新的Set<Map.Entry<K,V>>引用
        Iterator<Entry<K,V>> it = entrySet().iterator();
        // Get next prime capacity: 获取下一个素数作为容量
        capacity = nextPrime(capacity * 2);
        System.out.println("Rehashing, new capacity = " + capacity);
        buckets = new LinkedList[capacity]; //重新生成新容量的桶位列表
        threshold = (int)(capacity * loadFactor); //重新计算出阈值
        count = 0; //元素数量重置为0
        // Fill new buckets (crude, but it works):
        while(it.hasNext()) { //重新将扩容之前的映射put进去
            Map.Entry<K,V> me = it.next();
            put(me.getKey(), me.getValue());
        }
    }

}
