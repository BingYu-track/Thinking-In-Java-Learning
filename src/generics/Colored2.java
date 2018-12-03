package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/26 23:00
 */
class Colored2<T extends HasColor> extends HoldItem<T> {

    Colored2(T item) {
        super(item);
    }

    java.awt.Color color() {
        return item.getColor();
    }
}
