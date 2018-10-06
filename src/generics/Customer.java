package generics;
import java.util.*;
import net.mindview.util.*;
/**
 * @version 1.0
 * @Description: 匿名内部类使用泛型
 * @author: hxw
 * @date: 2018/10/6 18:23
 */
class Customer {

    private static long counter = 1;
    private final long id = counter++;
    private Customer() {}
    public String toString() { return "Customer " + id; }
    // A method to produce Generator objects:一个用来产生Generator对象的方法
    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            public Customer next() { return new Customer(); }
        };
    }
}
