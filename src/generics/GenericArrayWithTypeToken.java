package generics;

import java.lang.reflect.Array;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/26 0:12
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int sz) { //通过向构造器传入了类型标记，从而保证了实际类型与声明的泛型保持一致，就很容易避免之前两个示例出现的错误了
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Expose the underlying representation:
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<Integer>(Integer.class, 10);
        // This now works:
        Integer[] ia = gai.rep();
    }
}
