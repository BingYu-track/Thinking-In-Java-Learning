package generics;

/**
 * @version 1.0
 * @Description: 使用Object类来持有未知类型的对象()
 * @author: hxw
 * @date: 2018/9/23 19:02
 */
public class Holder2 {
    private Object a;
    public Holder2(Object a) { this.a = a; }
    public void set(Object a) { this.a = a; }
    public Object get() { return a; }
    public static void main(String[] args) {
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile)h2.get();
        h2.set("Not an Automobile");
        String s = (String)h2.get();
        h2.set(1); //自动装箱 Autoboxes to Integer
        Integer x = (Integer)h2.get();
    }
}
