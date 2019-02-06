package containers;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/6 20:15
 */
public class SlowMap2<K,V> extends AbstractMap<K,V> {


    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();

    @Override public V put(K key, V value) {
        if(key == null)
            throw new NullPointerException();
        V oldValue = get(key); // The old value or null
        if(!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else
            values.set(keys.indexOf(key), value);
        return oldValue;
    }

    @Override public V get(Object key) {
        if(key == null)
            throw new NullPointerException();
        if(!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    private EntrySet entrySet = new EntrySet();

    @Override
    public Set<Map.Entry<K,V>> entrySet() {
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
                    return index < keys.size() - 1;
                }

                public Map.Entry<K, V> next() {
                    canRemove = true;
                    ++index;
                    return new MapEntry<K, V>(keys.get(index), values.get(index));
                }

                public void remove() {
                    if (!canRemove)
                        throw new IllegalStateException();
                    canRemove = false;
                    keys.remove(index);
                    values.remove(index--);
                }
            };
        }

        @SuppressWarnings("unchecked")
        @Override public boolean contains(Object o) {
            if(o instanceof MapEntry) {
                MapEntry<K,V> e = (MapEntry<K,V>)o;
                K key = e.getKey();
                if(keys.contains(key)){
                    return e.equals(new MapEntry<K,V>(key, get(key)));
                }
            }
            return false;
        }

        @SuppressWarnings("unchecked")
        @Override public boolean remove(Object o) {
            if(contains(o)) {
                MapEntry<K,V> e = (MapEntry<K,V>)o;
                K key = e.getKey();
                V val = e.getValue();
                keys.remove(key);
                values.remove(val);
                return true;
            }
            return false;
        }

        @Override
        public int size() {
            return keys.size();
        }

        @Override
        public void clear() {
            keys.clear();
            values.clear();
        }
    }


}
