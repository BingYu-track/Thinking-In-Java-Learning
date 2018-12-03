package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/26 22:55
 */
class HoldItem<T> {

    T item;
    HoldItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}
