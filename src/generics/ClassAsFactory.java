package generics;

/**
 * @version 1.0
 * @Description: new T()无法实现:补偿方式1： 使用Class对象作为工厂对象创建实例来补偿
 * @author: hxw
 * @date: 2018/11/25 15:59
 */
class ClassAsFactory<T> {
    T x;
    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
