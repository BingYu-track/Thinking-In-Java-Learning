package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/13 23:05
 */
class C2 extends NotSelfBounded<C2>{

    C2 setAndGet(C2 arg) {
        set(arg);
        return get();
    }
}
