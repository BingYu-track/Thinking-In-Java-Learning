package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/26 22:46
 */
class Solid <T extends Dimension & HasColor & Weight>{ //与继承一样，你只能继承一个具体的类，但可以有多个接口(但类必须是在最前面)。

    T item;
    Solid(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
    java.awt.Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }

    int weight() {
        return item.weight();
    }
    
}
