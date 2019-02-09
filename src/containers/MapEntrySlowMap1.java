package containers;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/9 21:52
 */
public class MapEntrySlowMap1<K,V> extends AbstractMap<K,V> {

    protected List<MapEntry<K,V>> entries = new ArrayList<MapEntry<K,V>>();

    // Returns the entry matching the specified key, or null. 根据传入的key查找列表entries的映射
    protected MapEntry<K,V> getEntry(Object key) {
        for(MapEntry<K,V> entry : entries){
            if(entry.getKey().equals(key))
                return entry;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if(key == null)
            throw new NullPointerException();
        MapEntry<K,V> oldEntry = getEntry(key); //根据key获取旧的映射
        V oldValue = null;
        if(oldEntry == null){
            entries.add(new MapEntry<K,V>(key, value)); //为空就向ArraryList新增映射
        }else {
            oldValue = oldEntry.getValue(); //有就更新值
            oldEntry.setValue(value);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        if(key == null)
            throw new NullPointerException();
        MapEntry<K,V> entry = getEntry(key);
        return entry == null ? null : entry.getValue();
    }

    private EntrySet entrySet = new EntrySet();

    @Override
    public Set<Entry<K,V>> entrySet() {
        return entrySet;
    }

    // Uses the 'Flyweight' pattern
    private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Iterator<Map.Entry<K, V>>() {
                private int index = -1;
                boolean canRemove;

                public boolean hasNext() {
                    return index < entries.size() - 1;
                }

                public Map.Entry<K, V> next() {
                    canRemove = true;
                    ++index;
                    return entries.get(index);
                }

                public void remove() {
                    if (!canRemove)
                        throw new IllegalStateException();
                    canRemove = false;
                    entries.remove(index--);
                }
            };
        }

        @Override
        public boolean contains(Object o) {
            if(o instanceof MapEntry) {
                MapEntry<K,V> e = (MapEntry<K,V>)o;
                return e.equals(getEntry(e.getKey()));
            }
            return false;
        }

        @Override
        public boolean remove(Object o) {
            if(contains(o)) {
                entries.remove((MapEntry<K,V>)o);
                return true;
            }
            return false;
        }

        @Override
        public int size() {
            return entries.size();
        }
        @Override
        public void clear() {
            entries.clear();
        }
    }


}
