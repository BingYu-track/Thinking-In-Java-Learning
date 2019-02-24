package io;

import java.io.PrintWriter;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/24 15:15
 */
public class ChangeSystemOut {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true); //这里如果不用true，就不会清空缓冲，因此也就不会出现打印的结构
        out.println("Hello, world");
    }
}
