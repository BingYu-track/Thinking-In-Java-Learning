package exceptions.exercise;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/8 21:54
 */
class LoggingException2 extends Exception{
    private static Logger logger = Logger.getLogger("LoggingException2");
    public LoggingException2() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
