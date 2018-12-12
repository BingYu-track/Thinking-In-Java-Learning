package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/12 0:13
 */
public class BasicHolder<T> {
    T element;
    void set(T arg) { element = arg; }
    T get() { return element; }
    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
