package exceptions;

/**
 * @version 1.0
 * @Description: 重新抛出异常
 * @author: hxw
 * @date: 2018/7/10 8:35
 */
public class Rethrowing {

    public static void f() throws Exception {
        System.out.println("originating the exception in f()");
        throw new Exception("thrown from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch(Exception e) {
            System.out.println("Inside g(),e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;  //这里重写抛出异常，然后再main方法中打印的调用栈信息和之前一样
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside h(),e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception) e.fillInStackTrace(); //重新抛出异常，调用 fillInStackTrace()更新了"调用栈信息"
        }
    }

    public static void main(String[] args) {
        try {
            g(); //g方法再调用f方法
        } catch(Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
        try {
            h(); //h方法再调用f方法
        } catch(Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
