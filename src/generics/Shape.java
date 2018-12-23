package generics;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/23 20:39
 */
class Shape {

    public void rotate() { //旋转
        print(this + " rotate");
    }
    public void resize(int newSize) { //调整大小
        print(this + " resize " + newSize);
    }
}
