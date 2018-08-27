package typeinfo.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/27 8:40
 */
abstract class RShape {

    void draw() { System.out.println(this + ".draw()"); }
    abstract public String toString();

    //旋转
    void rotate(int degrees) {
        System.out.println("Rotating " + this + " by " + degrees + " degrees");
    }
}
