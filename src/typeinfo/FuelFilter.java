package typeinfo;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/4 22:35
 */
class FuelFilter extends Filter {

    // 为每种特定类型创建一个类工厂
    public static class Factory implements typeinfo.factory.Factory<FuelFilter> {
        public FuelFilter create() { return new FuelFilter(); }
    }
}
