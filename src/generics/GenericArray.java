package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/25 23:37
 */
public class GenericArray<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        array = (T[])new Object[sz]; //因为不能直接创建泛型数组 new T[]，所以这里先创建对象数组，再进行强转为T[]，但要注意这样做就丢失了其实际的类型（Object）,导致了后面的错误
    }
    public void put(int index, T item) {
        array[index] = item;
    }
    public T get(int index) {
        return array[index];
    }
    // Method that exposes the underlying representation:
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<Integer>(10);
        // This causes a ClassCastException: 运行时报错Object类型数组不能转为Integer数组。虽然返回的是T[]但实际上是Object[]
        Integer[] ia = gai.rep();
        // This is OK:
        Object[] oa = gai.rep();
    }
}
