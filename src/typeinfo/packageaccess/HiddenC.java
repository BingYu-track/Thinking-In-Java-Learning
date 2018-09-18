package typeinfo.packageaccess;

import typeinfo.interfacea.A;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/18 21:45
 */
public class HiddenC {

    public static A makeA() {
        return new C();
    }
    /*
    在packageaccess报外都无法使用A之外的任何方法，因为外部没有可用的C类
    */
}
