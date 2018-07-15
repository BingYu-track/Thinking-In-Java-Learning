package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/10 8:00
 */
public class E08_ExceptionSpecification {
    public static void main(String args[]) {
        Thrower t = new Thrower();
        try {
            t.g();
        } catch(MyException e) {
            e.printMsg();
        }
    }
}
