package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/13 23:02
 */
public class NotSelfBounded <T>{

    T element;
    NotSelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }
    T get() {
        return element;
    }

}
