package exceptions.exercise;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/8 21:57
 */
public class E07_LoggedArrayIndexBounds {

    private static Logger logger = Logger.getLogger("E07_LoggedArrayIndexBounds");
    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    public static void main(String args[]) {
        char[] array = new char[10];
        try {
            array[10] = 'x';
        } catch (ArrayIndexOutOfBoundsException e) {
            logException(e);
        }
    }
}
