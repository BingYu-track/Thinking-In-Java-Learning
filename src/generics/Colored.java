package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/26 22:35
 */
class Colored <T extends HasColor> {
    T item;
    Colored(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
    // 这个边界允许你调用HasColor接口中的方法:
    java.awt.Color color() {
        return item.getColor();
    }
}
