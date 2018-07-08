package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/8 21:55
 */
public class E06_LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException1();
        } catch(LoggingException1 e) {
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingException2();
        } catch(LoggingException2 e) {
            System.err.println("Caught " + e);
        }
    }
}
