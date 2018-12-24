package generics;

import java.util.Collection;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/24 8:00
 */
// To adapt a base type, you must use composition. Make any Collection Addable using composition:
// 若要调适配基类类型，必须使用组合。使用组合使任何集合都可添加：
class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;
    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    public void add(T item) {
        c.add(item);
    }
}
