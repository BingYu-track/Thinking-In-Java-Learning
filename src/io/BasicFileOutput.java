package io;

import java.io.*;

/**
 * @version 1.0
 * @Description: 基本文件输出
 * @author: hxw
 * @date: 2019/2/19 15:38
 */
public class BasicFileOutput {

    static String file = "BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        //将从文件读取到的数据以字符串形式保存到内存中
        String s1 = BufferedInputFile.read("BasicFileOutput.java");
        //StringReader以String为数据源
        StringReader stringReader = new StringReader(s1);
        //
        BufferedReader in = new BufferedReader(stringReader);
        //创建文件
        FileWriter fileWriter = new FileWriter(file);
        //使用BufferedWriter包装的含义是用缓冲输出，增加IO性能
        BufferedWriter bw = new BufferedWriter(fileWriter);
        PrintWriter out = new PrintWriter(bw);
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null )
            out.println(lineCount++ + ": " + s);
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
}
