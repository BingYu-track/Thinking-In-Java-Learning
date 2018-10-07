package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/10/7 13:44
 */
public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<HasF>(hf);
        manipulator.manipulate();
    }
}
