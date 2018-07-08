package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/8 20:46
 */
public class E05_Resumption {
    public static void main(String args[]) {
        while(true) {
            try {
                Resumer.f();
            } catch(ResumerException e) {
                System.out.println("Caught " + e);
                continue;
            }
            System.out.println("Got through...");
            break;
        }
        System.out.println("Successful execution");
    }
}
