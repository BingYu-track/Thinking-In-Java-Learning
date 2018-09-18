package typeinfo;

import sun.plugin2.os.windows.Windows;
import typeinfo.interfacea.A;
import typeinfo.packageaccess.HiddenC;

import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Description: 反射访问私有方法
 * @author: hxw
 * @date: 2018/9/18 21:53
 */
public class HiddenImplementation {

    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Compile error: cannot find symbol ‘C’:
        /* if(a instanceof C) {
                C c = (C)a;
                c.g();
            } */
        // !!反射仍然允许我们调用g()
        callHiddenMethod(a, "g");
        // 甚至是那些不易访问的方法
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }
    static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName); //返回公共、保护、默认（包）访问和私有方法，但不包括继承的方法
        g.setAccessible(true); //设置在用反射调用方法时不进行权限限制(即private也可以访问)
        //setAccessible是AccessibleObject类的方法，AccessibleObjec是Field、Method 和 Constructor 对象的基类。
        // 它提供了将反射的对象标记为在使用时取消默认 Java 语言访问控制检查的能力
        g.invoke(a);
    }
}
