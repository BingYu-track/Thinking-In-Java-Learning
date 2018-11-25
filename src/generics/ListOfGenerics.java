package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/25 21:19
 */
public class ListOfGenerics<T> {

    private List<T> array = new ArrayList<T>();
    public void add(T item) {
        array.add(item);
    }
    public T get(int index) {
        return array.get(index);
    }
}
