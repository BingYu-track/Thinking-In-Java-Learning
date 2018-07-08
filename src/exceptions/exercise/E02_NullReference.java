package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/8 20:35
 */
public class E02_NullReference {

    public static void main(String[] args){
        String s = null;
        // Causes a NullPointerException:
        //s.toString();
        try {
            s.toString();
        } catch(Exception e) {
            System.out.println("Caught exception " + e);
        }
    }
}
