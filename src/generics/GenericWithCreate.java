package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/25 16:45
 */
abstract class GenericWithCreate<T> {
    final T element;
    //模板方法
    GenericWithCreate() {
        element = create();
    }
    //用于子类实现
    abstract T create();
}
