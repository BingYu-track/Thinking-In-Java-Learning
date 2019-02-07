package containers;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/8 0:46
 */
public class SimpleHashSet<K> extends AbstractSet<K> {

    private final static int SIZE = 997;

    @SuppressWarnings("unchecked")
    private LinkedList<K>[] buckets = new LinkedList[SIZE];

    public boolean add(K key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null)
            buckets[index] = new LinkedList<K>();
        LinkedList<K> bucket = buckets[index];
        ListIterator<K> it = bucket.listIterator();
        while(it.hasNext()){
            if(it.next().equals(key))
                return false;
        }
        // Sets do not permit duplicates and one was already in the set. 集合不允许重复，其中一个已经在集合中。
        it.add(key);
        return true;
    }

    public boolean contains(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null)
            return false;
        Iterator<K> it = buckets[index].iterator();
        while(it.hasNext()){
            if(it.next().equals(key))
                return true;
        }
        return false;
    }

    public int size() {
        int sz = 0;
        for(LinkedList<K> bucket : buckets) {
            if(bucket != null)
                sz += bucket.size();
        }
        return sz;
    }



    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int count; //当前遍历的位置，类似游标
            private boolean canRemove;
            private int index1, //当前桶位
                    index2; //桶位中元素的位置

            public boolean hasNext() {
                return count < size();
            }

            public K next() {
                if (hasNext()) {
                    canRemove = true;
                    ++count;
                    for (; ; ) {
                    // Position of the next non-empty bucket 寻下一个非空桶的位置
                        while (buckets[index1] == null)
                            ++index1;
                        // Position of the next item to return 找到非空桶位(即链表)返回下一个项目的位置
                        try {
                            return buckets[index1].get(index2++);
                        } catch (IndexOutOfBoundsException e) {
                        // Continue search from the next bucket 如果索引超出范围,从下一个桶继续搜索
                            ++index1;
                            index2 = 0;
                        }
                    }
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                if(canRemove) {
                    canRemove = false;
                    buckets[index1].remove(--index2);
                    if(buckets[index1].isEmpty()) { // Housekeeping...
                        buckets[index1++] = null;
                    }
                    --count;
                } else
                    throw new IllegalStateException();
            }

        };
    }

}
