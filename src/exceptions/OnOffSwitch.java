package exceptions;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/17 22:03
 */
public class OnOffSwitch {
    private static Switch sw = new Switch();
    public static void f()throws OnOffException1,OnOffException2 {

    }
    public static void main(String[] args) {
        try {
            sw.on();
        // Code that can throw exceptions...
            f();
            sw.off();
        } catch(OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off(); //关闭开关
        } catch(OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
    }
}
