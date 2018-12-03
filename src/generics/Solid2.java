package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/26 23:06
 */
class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T> {

    Solid2(T item) {
        super(item);
    }

    int weight() {
        return item.weight();
    }
}
