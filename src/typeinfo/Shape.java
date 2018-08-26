package typeinfo;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/26 17:03
 */
abstract class Shape {
    void draw() { System.out.println(this + ".draw()"); }
    abstract public String toString();
}
