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
        //使用BufferedWriter包装的含义是用缓冲输出，增加IO性能,再用PrintWriter包装提升格式,如果不用PrintWriter，则所有字符串都写到一行去了
        BufferedWriter bw = new BufferedWriter(fileWriter);
        PrintWriter out = new PrintWriter(bw);
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null ) //这里BufferedReader读取一行，然后用下面PrintWriter写入时加上行号
            out.println(lineCount++ + ": " + s); //必须注意：这里写入到的不是文件，而是写到缓冲区里
        out.close(); //关闭该流并释放与之关联的所有系统资源，会把缓冲区里的所有数据强制写出  问题：为什么注释这行代码，下面BufferedReader就读不到数据了?

        //答：因为java在使用流时,都会有一个缓冲区:把要发的数据先放到缓冲区,缓冲区放满以后再一次性发过去,而不是分开一次一次地发.
        //而flush()表示强制将缓冲区中的数据发送出去,不必等到缓冲区满.如果这里不调用close()方法，也就不会把缓冲区中的数据发出去，
        // 文件里面之间的数据就被覆盖，变成空文件了，因此后面的BufferedReader就读不到数据了
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
    /*
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("foo.out")));
     将缓冲 PrintWriter 对文件的输出。如果没有缓冲，则每次调用 print() 方法会导致将字符转换为字节，然后立即写入到文件，而这是极其低效的。
     */

}
