package exceptions;

import java.io.FileInputStream;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/3 8:32
 */
public class MainException {
    // 将所有异常传递到控制台：
    public static void main(String[] args) throws Exception {
        // Open the file:
        FileInputStream file = new FileInputStream("MainException.java");
        // Use the file ...
        // Close the file:
        file.close();
    }
}
