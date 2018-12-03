package generics;

/**
 * @version 1.0
 * @Description:普通类实现工厂
 * @author: hxw
 * @date: 2018/11/25 16:26
 */
class IntegerFactory implements FactoryI<Integer>{

    @Override
    public Integer create() {
        return new Integer(0);
    }
}
