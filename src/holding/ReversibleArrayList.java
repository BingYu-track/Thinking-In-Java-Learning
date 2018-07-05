package holding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/5 8:40
 */
class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c) {
        super(c);
    }
    //反转
    public Iterable<T> reversed() {
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;  //c从最后一个元素开始
                    public boolean hasNext() { return current > -1; } //当前索引大于-1表示有下一个元素
                    public T next() { return get(current--); } //取出元素后将当前取出的元素索引减1
                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
