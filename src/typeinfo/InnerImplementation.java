package typeinfo;

import typeinfo.interfacea.A;

/**
 * @version 1.0
 * @Description: 反射访问私有内部类
 * @author: hxw
 * @date: 2018/9/18 22:20
 */
public class InnerImplementation {

    public static void main(String[] args) throws Exception {
        A a = InnerA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // 反射仍然可以获取私有内部类
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
}
