package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/7/19 21:55
 */
public class InputFile {
    private BufferedReader in;

    //InputFile构造器
    public InputFile(String fname) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fname));
            //下面是其他可能引发异常的代码
            //........................
        } catch(FileNotFoundException e) {
            System.out.println("Could not open " + fname);
            // 当捕获到FileNotFoundException说明文件没有打开，所以不需要关闭流
            throw e;
        } catch(Exception e) {
            //而当捕获到所有其他异常时(不是FileNotFoundException)说明文件已经打开，那么必须关闭该流。
            try {
                in.close();
            } catch(IOException e2) {
                System.out.println("in.close() unsuccessful"); //关闭流失败
            }
            throw e; // 重新抛出异常 这是适当的，因为此构造函数失败，而且可以避免误导调用者"对象已正确创建并有效"。
        } finally {
        // 不要在这里关闭流，因为我们希望创建的InputFile对象在整个生命周期内，流都处于打开转态
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine(); //如果上面方法中finally字句里有关闭流的操作，这里就无法执行
        } catch(IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch(IOException e2) {
            throw new RuntimeException("in.close() failed");
        }
    }
}
