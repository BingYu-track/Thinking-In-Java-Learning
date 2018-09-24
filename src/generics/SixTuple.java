package generics;

import net.mindview.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/24 14:00
 */
public class SixTuple<A,B,C,D,E,F> extends FiveTuple<A,B,C,D,E> {

    public final F sixth;
    public SixTuple(A a, B b, C c, D d, E e, F f) {
        super(a, b, c, d, e);
        sixth = f;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " +
                third + ", " + fourth + ", " + fifth + ", " +
                sixth + ")";
    }
}
