package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/24 10:15
 */
class Holder4<T> {

    private T a, b, c;
    public Holder4(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void setA(T a) { this.a = a; }
    public void setB(T b) { this.b = b; }
    public void setC(T c) { this.c = c; }
    public T getA() { return a; }
    public T getB() { return b; }
    public T getC() { return c; }
}
