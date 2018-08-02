package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/2 8:39
 */
public class E25_ThreeLevelExceptions {

    public static void main(String args[]) {
        A a = new C();
        try {
            a.f();
        } catch(Level1Exception e) {
            System.out.println("Caught " + e);
        }
    }
}
