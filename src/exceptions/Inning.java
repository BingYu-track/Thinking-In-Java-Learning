package exceptions;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/17 23:29
 */
abstract class Inning {
    public Inning() throws BaseballException {

    }
    //通过子类StormyInning实现了接口Storm的event()方法
    public void event() throws BaseballException {
    // Doesn’t actually have to throw anything 实际不需要抛任何异常
    }
    public abstract void atBat() throws Strike, Foul;
    public void walk() { //没有异常需要检查

    } // Throws no checked exceptions
}
