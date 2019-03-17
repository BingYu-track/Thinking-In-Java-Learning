package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @version 1.0
 * @Description: 有缓冲和无缓冲IO性能对比
 * @author: hxw
 * @date: 2019/2/20 15:22
 */
public class E14_BufferPerformance {

    static String file = "E14_BufferPerformance.out";

    public static void main(String[] args) throws IOException {
        List<String> list = E07_FileIntoList.read("E14_BufferPerformance.java");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        long t1 = System.currentTimeMillis();
        for(String s : list) { //带缓冲区，每一行输出1万遍
            for(int i = 0; i < 10000; i++){
                out.println(lineCount + ": " + s);
            }
            lineCount++;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("buffered: " + (t2 - t1)); //257
        out.close();

        out = new PrintWriter(new FileWriter(file));
        lineCount = 1;
        t1 = System.currentTimeMillis();
        for(String s : list) { //不带缓冲区
            for(int i = 0; i < 10000; i++){
                out.println(lineCount + ": " + s);
            }
            lineCount++;
        }
        t2 = System.currentTimeMillis();
        System.out.println("unbuffered: " + (t2 - t1)); //281
        out.close();
    }
}
