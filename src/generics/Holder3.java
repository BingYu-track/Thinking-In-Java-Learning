package generics;

/**
 * @version 1.0
 * @Description: 使用类型参数，代码变的更通用
 * @author: hxw
 * @date: 2018/9/23 19:51
 */
public class Holder3<T> {
    private T a;
    public Holder3(T a) {
        this.a = a;
    }
    public void set(T a) {
        this.a = a;
    }
    public T get() {
        return a;
    }
    public static void main(String[] args) {
        Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
        Automobile a = h3.get(); // No cast needed 不需要再转型
        // h3.set("Not an Automobile"); // Error
        // h3.set(1); // Error
    }
}
