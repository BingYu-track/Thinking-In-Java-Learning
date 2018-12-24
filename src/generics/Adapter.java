package generics;

import java.util.Collection;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/24 8:01
 */
// A Helper to capture the type automatically:
class Adapter {

    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<T>(c);
    }
}
