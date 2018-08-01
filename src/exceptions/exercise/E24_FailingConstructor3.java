package exceptions.exercise;


/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/1 23:54
 */
public class E24_FailingConstructor3 {

    public static void main(String[] args){
        for(boolean b = false; ; b = !b){
            try {
                System.out.println("Constructing...");
                FailingConstructor3 fc = new FailingConstructor3(b);
                try {
                    System.out.println("Processing...");
                } finally {
                    System.out.println("Cleanup...");
                    fc.dispose();  //执行到这里说明初始化成功，处理完后统一清理
                }
            } catch(ConstructionException e) {
                System.out.println("Construction has failed: " + e);
                break;
            }
        }
    }
}
