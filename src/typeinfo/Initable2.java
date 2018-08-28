package typeinfo;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/28 22:36
 */
public class Initable2 {

    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}
