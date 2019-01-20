package containers;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/20 18:36
 */
public class Pair<K,V> {

    public final K key;
    public final V value;
    public Pair(K k, V v) {
        key = k;
        value = v;
    }
}
