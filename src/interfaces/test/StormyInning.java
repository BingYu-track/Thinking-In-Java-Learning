package interfaces.test;

/**
 * @version 1.0
 * @Description: 子类继承父类和实现接口同名方法
 * @author: hxw
 * @date: 2018/7/18 21:53
 */
class StormyInning extends Inning implements Storm {

    //发现没有让我们实现接口中event同名的方法，其实这种情况下默认父类Inning实现接口Storm的event方法，当我注释掉父类Inning的event方法时发现
    //就需要我们强制实现接口中的event方法了
    @Override
    public void rainHard() {

    }
}
