package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/7 21:10
 */
public class E20_Bounds {

    static <T extends Top> void f(T obj) {
        obj.a();
        obj.b();
        //c();is not part of an interface
        // obj.c();
    }
    public static void main(String[] args) {
        f(new CombinedImpl());
    }
}
