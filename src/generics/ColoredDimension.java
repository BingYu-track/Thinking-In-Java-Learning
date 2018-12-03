package generics;

/**
 * @version 1.0
 * @Description: 多个边界
 * @author: hxw
 * @date: 2018/11/26 22:41
 */
class ColoredDimension <T extends Dimension & HasColor> { //注意不能这样写：class ColoredDimension<T extends HasColor & Dimension> {，类必须在第一个，然后才是接口

    T item;
    ColoredDimension(T item) {
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
}
