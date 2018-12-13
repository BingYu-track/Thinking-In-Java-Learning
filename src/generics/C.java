package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/13 21:30
 */
class C extends SelfBounded<C>{

    C setAndGet(C arg) {
        set(arg); return get();
    }
}
