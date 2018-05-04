package innerclasses.multiextends;

/**
 * @Description: 匿名内部类实现多继承
 * @Author:hxw
 * @Date:2018/5/4 14:26
 */
public class MultiImplementation {

    static void takesD(D d) {}
    static void takesE(E e) {}
    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}
