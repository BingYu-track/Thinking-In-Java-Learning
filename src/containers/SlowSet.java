package containers;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/6 21:14
 */
public class SlowSet<K> extends AbstractSet<K> {

    private List<K> keys = new ArrayList<K>();
    public boolean add(K key) {
        if(!contains(key)) {
            keys.add(key);
            return true;
        }
        return false;
    }

    public Iterator<K> iterator() {
        return keys.iterator();
    }

    public int size() {
        return keys.size();
    }

}
