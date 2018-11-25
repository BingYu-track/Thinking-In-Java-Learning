package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/25 16:46
 */
class Creator extends GenericWithCreate<X>{
    @Override
    X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName()); //此时element为X对象
    }
}
