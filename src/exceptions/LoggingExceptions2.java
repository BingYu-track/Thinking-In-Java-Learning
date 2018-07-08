package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/8 21:08
 */
public class LoggingExceptions2 extends Exception {
    private static Logger logger = Logger.getLogger("LoggingExceptions2");
    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch(NullPointerException e) {
            logException(e);
        }
    }
}
