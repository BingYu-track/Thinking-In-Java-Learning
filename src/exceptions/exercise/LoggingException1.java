package exceptions.exercise;
import java.util.logging.*;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/8 21:54
 */
class LoggingException1 extends Exception{
    private static Logger logger = Logger.getLogger("LoggingException1");
    public LoggingException1() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
