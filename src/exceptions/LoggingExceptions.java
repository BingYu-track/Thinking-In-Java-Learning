package exceptions;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/8 21:00
 */
public class LoggingExceptions {
    public static void main(String[] args){
        try {
            throw new LoggingException();
        } catch(LoggingException e) {
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingException();
        } catch(LoggingException e) {
            System.err.println("Caught " + e);
        }
    }
}
