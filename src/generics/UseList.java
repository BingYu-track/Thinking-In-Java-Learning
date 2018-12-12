package generics;

import java.util.List;

/**
 * @version 1.0
 * @Description: 泛型重载
 * @author: hxw
 * @date: 2018/12/11 23:13
 */
public class UseList<W,T> {

    //void f(List<T> v) {} //由于擦除，该方法会产生相同类型的签名(即T和W都擦除成了Object)
    void f(List<W> v) {}
}
