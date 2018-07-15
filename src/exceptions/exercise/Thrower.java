package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/10 7:56
 */
class Thrower {
    public void f() throws MyException {

        throw new MyException("Inside f()"); //要么在方法上声明抛出异常，要么try catch
    }
    public void g() throws MyException {
        throw new MyException("Inside g()");
    }
}
