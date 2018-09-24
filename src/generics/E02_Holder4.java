package generics;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/9/24 10:16
 */
public class E02_Holder4 {

    public static void main(String[] args) {
        Holder4<String> h4 = new Holder4<String>("A", "B", "C");
        System.out.println(h4.getA());
        System.out.println(h4.getB());
        System.out.println(h4.getC());
        h4.setC("D");
        System.out.println(h4.getC());
    }
}
