package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/5 22:15
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;
    public long id() { return id; }
    public String toString() {
        return "CountedObject " + id;
    }
    /*
    final变量是在初始化时设置值，如果是基本型，初始化后不能在改变。
    上例中CountedObject的属性 id 是final型的， 对于不同的对象初始化的初始值是不同的，因此打印出来的值是不同的。
    */
}
