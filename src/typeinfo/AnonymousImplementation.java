package typeinfo;

import typeinfo.interfacea.A;

/**
 * @version 1.0
 * @Description: 反射访问匿名内部类
 * @author: hxw
 * @date: 2018/9/18 22:25
 */
public class AnonymousImplementation {

    public static void main(String[] args) throws Exception {
        A a = AnonymousA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Reflection still gets into the anonymous class:
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
}
