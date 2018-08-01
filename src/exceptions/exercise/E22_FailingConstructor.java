package exceptions.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/1 23:29
 */
public class E22_FailingConstructor {

    public static void main(String args[]) {
        for(boolean b = false; ; b = !b){
            try {
                System.out.println("Constructing...");
                FailingConstructor fc = new FailingConstructor(b);
                try {
                    System.out.println("Processing...");
                } finally {
                    System.out.println("Cleanup...");
                }
            } catch(ConstructionException e) {
                System.out.println("Construction has failed: " + e);
                break;
            }
        }
    }
}
