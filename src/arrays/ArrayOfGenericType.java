package arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/31 22:58
 */
public class ArrayOfGenericType<T> {

    T[] array; // OK
    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
        //! array = new T[size]; // Illegal 不能直接创建泛型数组
        array = (T[])new Object[size]; // "unchecked" Warning
    }
    // Illegal:
    //! public <U> U[] makeArray() { return new U[10]; }
}
