package containers;

import java.util.Map;

/**
 * @version 1.0
 * @Description: 自定义Map.Entry的实现
 * @author: hxw
 * @date: 2019/2/6 19:38
 */
public class MapEntry<K,V> implements Map.Entry<K,V> {

    private K key;
    private V value;
    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }

    public int hashCode() {
        return (key==null ? 0 : key.hashCode()) ^
                (value==null ? 0 : value.hashCode()); //key值的hashCode与value的hashCode的异或运算
    }
    public boolean equals(Object o) {
        if(!(o instanceof MapEntry)){
            return false;
        }
        MapEntry me = (MapEntry)o;
        return
                (key == null ? me.getKey() == null : key.equals(me.getKey())) &&
                        (value == null ? me.getValue()== null : value.equals(me.getValue()));
    }

    public String toString() {
        return key + "=" + value;
    }


}
