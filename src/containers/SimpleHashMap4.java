package containers;

import java.util.LinkedList;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 0:36
 */
public class SimpleHashMap4<K,V> extends SimpleHashMap3<K,V> {

    public int size() {
        // Could rely on the inherited implementation, which returns entrySet().size(), but this is faster:
        // 可以依赖继承AbstractMap.size()的实现，该实现返回entrySet().size()，但我们自定义的更快
        int sz = 0;
        for(LinkedList<MapEntry<K,V>> bucket : buckets){ //遍历链表数组，获取数组里所有链表大小的总和
            if(bucket != null)
                sz += bucket.size();
        }
        return sz;
    }

    public boolean isEmpty() {
        // Could just say return size() == 0; but this is faster:
        for(LinkedList<MapEntry<K,V>> bucket : buckets)
            if(bucket != null)
                return false;
        return true;
    }

    public boolean containsKey(Object key) {
        // A slight modification of the previous method:
        for(LinkedList<MapEntry<K,V>> bucket : buckets) {
            if(bucket == null) {
                continue;
            }
            for(MapEntry<K,V> mPair : bucket){
                if(mPair.getKey().equals(key))
                    return true;
            }
        }
        return false;
    }

}
