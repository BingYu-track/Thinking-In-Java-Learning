package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.logging.*;

/**
 * @version 1.0
 * @Description: 异常与记录日志
 * @author: hxw
 * @date: 2018/7/8 20:58
 */
class LoggingException extends Exception{
    private static Logger logger = Logger.getLogger("LoggingException");
    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
