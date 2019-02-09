package containers;

import java.util.Collections;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/9 22:06
 */
public class MapEntrySlowMap2<K,V> extends MapEntrySlowMap1<K,V> {

    final MapEntryComp<K,V> comp = new MapEntryComp<K,V>(); //比较器

    // Returns the entry matching the specified key, or null.
    @Override
    protected MapEntry<K,V> getEntry(Object key) {
        MapEntry<K,V> searchEntry = new MapEntry<K,V>((K)key, null);
        int index = Collections.binarySearch(entries, searchEntry, comp); //从entries列表中使用二分法搜索searchEntry，搜索比较规则是comp
        if(index >= 0){ //如果index>=0才表示有该元素
            return entries.get(index);
        }
        return null;
    }

    @Override
    public V put(K key, V value) { //这里的put方法更慢，因为还要进行额外的排序操作
        if(key == null)
            throw new NullPointerException();
        MapEntry<K,V> oldEntry = getEntry(key);
        V oldValue = null;
        if(oldEntry == null) {
            entries.add(new MapEntry<K,V>(key, value));
            Collections.sort(entries, comp); //向里面加入一个元素是就排一次序
        } else {
            oldValue = oldEntry.getValue();
            oldEntry.setValue(value);
        }
        return oldValue;
    }

}
