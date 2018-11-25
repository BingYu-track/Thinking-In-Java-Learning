package generics;

/**
 * @version 1.0
 * @Description: 擦除丢失了一些操作能力----任何在运行时需要知道确切类型信息的操作都将无法工作
 * @author: hxw
 * @date: 2018/10/9 8:01
 */
public class Erased<T> {
    private final int SIZE = 100;
    public static void f(Object arg) {
        /*if(arg instanceof T) {} // Error 在这里使用instanceof报错，因为类型信息已经被擦除;但是我们可以引入类型标签转而使用动态的isInstance()方法来补偿
        T var = new T(); // Error
        T[] array = new T[SIZE]; // Error
        T[] array = (T)new Object[SIZE]; // Unchecked warning*/
    }
}
