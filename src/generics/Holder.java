package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/6 8:29
 */
public class Holder<T> {
    private T value;
    public Holder() {}

    public Holder(T val) {
        value = val;
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    public boolean equals(Object obj) {
        return value.equals(obj);
    }
    public static void main(String[] args) {
        Holder<Apple> Apple = new Holder<Apple>(new Apple());
        Apple d = Apple.get();
        Apple.set(d);
        // Holder<Fruit> Fruit = Apple; // Holder<Apple>无法向上转型为Holder<Fruit> 因为泛型不支持协变
        Holder<? extends Fruit> fruit = Apple; // Holder<Apple>允许向上转型为Holder<? extends Fruit>
        Fruit p = fruit.get(); //get方法只返回Fruit类型，因为编译器从<? extends Fruit>唯一确定的信息就是Fruit，如果编译器了解更多具体信息，那么就可以转型到具体的某种Fruit类型
        d = (Apple)fruit.get(); // Returns ‘Object’
        try {
            Orange c = (Orange)fruit.get(); // No warning但存在ClassCastException风险
        } catch(Exception e) { System.out.println(e); }
        // fruit.set(new Apple()); // Cannot call set() 无法使用set方法
        // fruit.set(new Fruit()); // Cannot call set()
        System.out.println(fruit.equals(d)); // OK
    }
}
