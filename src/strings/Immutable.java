package strings;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/4 22:54
 */
public class Immutable {

    public static String upcase(String s) {
        return s.toUpperCase();
    }
    public static void main(String[] args) {
        String q = "howdy";
        System.out.println(q); // howdy
        String qq = upcase(q);
        System.out.println(qq); // HOWDY
        System.out.println(q); // howdy
    }
}
