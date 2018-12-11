package generics;

/**
 * @version 1.0
 * @Description: 转型警告
 * @author: hxw
 * @date: 2018/12/11 21:54
 */
class FixedSizeStack<T> {
    private int index = 0;
    private Object[] storage;
    public FixedSizeStack(int size) {
        storage = new Object[size];
    }
    public void push(T item) {
        storage[index++] = item;
    }

    //@SuppressWarnings("unchecked")
    public T pop() {
        return (T)storage[--index]; //编译器转型警告，由于擦除，编译器无法知道该转型是否安全(实际上T被擦除为Object,因此实际是Object转为了Object)
    }

}
