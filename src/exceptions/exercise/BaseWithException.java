package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/1 23:11
 */
class BaseWithException {
    public BaseWithException() throws Except1 {
        throw new Except1("thrown by BaseWithException");
    }
}
