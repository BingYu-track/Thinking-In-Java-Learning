package exceptions;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/1 8:19
 */
public class Cleanup {

    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("D:\\Eclipse_Code\\ThinkInJava\\src\\exceptions\\Cleanup.java");
            try {
                String s;
                int i = 1;
                while((s = in.getLine()) != null)
                    ; // Perform line-by-line processing here...
            } catch(Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            } finally {
                in.dispose();
            }
        } catch(Exception e) {
            //InputFile初始化失败进入该catch子句
            System.out.println("InputFile construction failed");
        }
    }
}
