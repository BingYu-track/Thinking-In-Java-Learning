package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/11/25 16:27
 */
class Widget {
    //内部类实现工厂
    public static class Factory implements FactoryI<Widget> {
        public Widget create() {
            return new Widget();
        }
    }
}
