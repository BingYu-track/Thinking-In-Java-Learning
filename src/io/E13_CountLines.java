package io;

import java.io.*;

/**
 * @version 1.0
 * @Description: 使用LineNumberReader来记录行数
 * @author: hxw
 * @date: 2019/2/20 14:49
 */
public class E13_CountLines {

    static String file = "E13_CountLines.out";

    public static void main(String[] args) throws IOException {
        // LineNumberReader is inherited from BufferedReader so we don't need to explicitly buffer it:
        //翻译：LineNumberReader 继承BufferedReader，因此它不需要明确的缓冲
        LineNumberReader in = new LineNumberReader(new FileReader("E13_CountLines.java")); //数据来源
        PrintWriter out = new PrintWriter(file);
        String s;
        while((s = in.readLine()) != null )
            out.println(in.getLineNumber() + ": " + s);
        out.close();
        // Show the stored file:
        System.out.println(E07_FileIntoList.read(file));
        //LineNumberReader从1开始计数，而大多数计数从零开始。
    }
}
