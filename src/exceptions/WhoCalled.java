package exceptions;

/**
 * @version 1.0
 * @Description: 栈轨迹
 * @author: hxw
 * @date: 2018/7/10 8:16
 */
public class WhoCalled {

    static void f() {
        // Generate an exception to fill in the stack trace
        try {
            throw new Exception();
        } catch (Exception e) {
            for(StackTraceElement ste : e.getStackTrace()) //遍历调用栈信息
                System.out.println(ste.getMethodName());
        }
    }
    static void g() {
        f();
    }
    static void h() {
        g();
    }
    public static void main(String[] args){
        f();
        System.out.println("--------------------------------");
        g();
        System.out.println("--------------------------------");
        h();
    }
}
