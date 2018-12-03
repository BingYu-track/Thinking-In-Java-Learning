package generics;

/**
 * @version 1.0
 * @Description: 边界
 * @author: hxw
 * @date: 2018/11/26 22:49
 */
public class BasicBounds {

    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
        Bounded item = solid.getItem();
    }
}
