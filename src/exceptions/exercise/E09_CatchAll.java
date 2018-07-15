package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/10 8:11
 */
public class E09_CatchAll {

    public static void main(String args[]) {
        Thrower2 t = new Thrower2();
        try {
            t.f();
        } catch(ExBase e) {
            System.out.println("caught " + e);
        } catch(Exception e) {
            System.out.println("caught " + e);
        }
    }
}
