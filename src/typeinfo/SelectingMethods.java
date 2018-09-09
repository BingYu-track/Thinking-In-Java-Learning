package typeinfo;

import java.lang.reflect.Proxy;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/9 20:30
 */
public class SelectingMethods {

    public static void main(String[] args) {
        SomeMethods proxy= (SomeMethods)Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[]{ SomeMethods.class },
                new MethodSelector(new Implementation())
        );
        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bonobo");
        proxy.boring3();
    }
}
