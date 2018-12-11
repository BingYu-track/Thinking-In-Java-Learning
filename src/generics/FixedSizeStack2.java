package generics;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/11 23:00
 */
class FixedSizeStack2<T> {
    private int index;
    private final int size;
    private final List<T> storage; //使用泛型List代替数组
    public FixedSizeStack2(int size) {
        storage = new ArrayList<T>(size);
        this.size = size;
    }

    public void push(T item) {
        if(index < size) {
            index++;
            storage.add(item);
        } else{
            throw new FullStackException();
        }
    }

    public T pop() {
        if(index > 0){
            return storage.get(--index);
        }
        throw new EmptyStackException();
    }
}
