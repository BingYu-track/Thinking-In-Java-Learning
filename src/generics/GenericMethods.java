package generics;

/**
 * @version 1.0
 * @Description: 泛型方法
 * @author: hxw
 * @date: 2018/10/3 14:54
 */
public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1); //自动装箱
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
        /*
            java.lang.String
            java.lang.Integer
            java.lang.Double
            java.lang.Float
            java.lang.Character
            generics.GenericMethods
        */
    }
}
