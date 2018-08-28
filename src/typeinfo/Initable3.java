package typeinfo;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/28 22:38
 */
public class Initable3 {

    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}
