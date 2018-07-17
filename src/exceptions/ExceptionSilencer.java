package exceptions;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/17 22:51
 */
public class ExceptionSilencer {

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } finally {
           //在finally语句块直接使用return,即使抛出了异常，也不会有任何输出。
            return;
        }
    }
}
