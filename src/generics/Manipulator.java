package generics;

/**
 * @version 1.0
 * @Description: 对比C++的泛型
 * @author: hxw
 * @date: 2018/10/7 13:38
 */
public class Manipulator<T> {
    private T obj;
    public Manipulator(T x) { obj = x; }
    // Error: cannot find symbol: method f(): 编译错误，正是由于擦除，泛型对象obj找不到f()方法
    public void manipulate() {
        //obj.f();
    }
}
