package generics;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/23 20:44
 */
public class SimpleQueue<T> implements Iterable<T> {

    private LinkedList<T> storage = new LinkedList<T>();
    public void add(T t) {
        storage.offer(t); //offer() 将指定的元素添加到列表的尾部
    }

    public T get() {
        return storage.poll(); //poll() 检索并删除此列表的头（第一个元素）。
    }

    public Iterator<T> iterator() {
        return storage.iterator(); //获得迭代器
    }
}
