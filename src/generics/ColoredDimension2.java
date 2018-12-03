package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/26 23:05
 */
class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T> { //如果一个泛型类的父类也是一个泛型类，那么该泛型类的类型参数与父类的类型参数在同一范围内

    ColoredDimension2(T item) {
        super(item);
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
