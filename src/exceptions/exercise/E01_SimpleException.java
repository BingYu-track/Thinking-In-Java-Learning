package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/8 20:33
 */
public class E01_SimpleException {

    public static void main(String[] args){
        try {
            throw new Exception("An exception in main");
        } catch(Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } finally {
            System.out.println("In finally clause");
        }
    }
}
