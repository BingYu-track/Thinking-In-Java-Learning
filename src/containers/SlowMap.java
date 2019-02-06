package containers;

import java.util.*;
import net.mindview.util.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/6 19:03
 */
public class SlowMap<K,V> extends AbstractMap<K,V> {

    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();

    public V put(K key, V value) {
        V oldValue = get(key); // The old value or null 返回旧值或null
        if(!keys.contains(key)) { //不包含当前key就新增
            keys.add(key);
            values.add(value);
        }else{
            values.set(keys.indexOf(key), value); //否则修改
        }
        return oldValue;
    }

    public V get(Object key) { // key is type Object, not K 这里参数key是Object类型，而不是K，这是因为这里的get(K)与‘java.util.DigactMap’中的‘get(Object)’冲突；这两种方法具有相同的擦除性
        if(!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>(); //这行代码导致了后面操作的问题
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while(ki.hasNext()){
            set.add(new MapEntry<K,V>(ki.next(), vi.next()));
        }
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String,String> m = new SlowMap<String,String>();
        m.putAll(Countries.capitals(15));
        System.out.println(m);
        System.out.println(m.get("BULGARIA"));
        System.out.println(m.entrySet());
    }
}
