package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/26 23:07
 */
public class InheritBounds {

    public static void main(String[] args) {
        Solid2<Bounded> solid2 = new Solid2<Bounded>(new Bounded());
        solid2.color();
        solid2.getY();
        solid2.weight();
    }
}
