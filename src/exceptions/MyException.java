package exceptions;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/8 20:28
 */
class MyException extends Exception{
    public MyException() {}
    public MyException(String msg) {
        super(msg);
    }
}
