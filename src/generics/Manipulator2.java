package generics;

/**
 * @version 1.0
 * @Description: 添加边界 <T extends HasF>声明T是HasF或HasF的子类，这样就可以调用f()
 * @author: hxw
 * @date: 2018/10/7 20:22
 */
class Manipulator2<T extends HasF> {
    private T obj;
    public Manipulator2(T x) { obj = x; }
    public void manipulate() { obj.f(); }
    /*
    添加边界 <T extends HasF>声明T是HasF或HasF的子类，这样就可以调用f();这相当于把T擦除替换成了HasF,在这里泛型
    没有提供任何好处，与generics.Manipulator3代码是一样的，就没必要使用泛型，"只有当你希望代码能跨多个类工作时，使用泛型才
    有所帮助"
    **/
}
