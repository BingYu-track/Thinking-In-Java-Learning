package generics;

/**
 * @version 1.0
 * @Description: 元祖
 * @author: hxw
 * @date: 2018/9/24 10:28
 */
public class TwoTuple<A,B> {
    public final A first;
    public final B second;
    public TwoTuple(A a, B b) { first = a; second = b; }
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
