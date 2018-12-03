package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/25 16:25
 */
class Foo2<T> {
    private T x;
    //F为工厂
    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }
}
