package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/13 21:15
 */
class SelfBounded <T extends SelfBounded<T>> {

    T element;
    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }
    T get() {
        return element;
    }

}
