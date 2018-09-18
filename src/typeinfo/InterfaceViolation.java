package typeinfo;

import typeinfo.interfacea.A;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/18 21:30
 */
public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        // a.g(); // Compile error
        System.out.println(a.getClass().getName());
        if(a instanceof B) {
            B b = (B)a;
            b.g();
        }
    }
}
