package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/24 8:02
 */
// To adapt a specific type, you can use inheritance. Make a SimpleQueue Addable using inheritance:
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {

    public void add(T item) {
        super.add(item);
    }
}
