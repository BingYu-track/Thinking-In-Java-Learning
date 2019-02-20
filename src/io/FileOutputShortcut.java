package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @version 1.0
 * @Description: PrintWriter的更方便的构造器 PrintWriter(String fileName)
 * @author: hxw
 * @date: 2019/2/20 14:32
 */
public class FileOutputShortcut {

    static String file = "FileOutputShortcut.out";
    public static void main(String[] args) throws IOException {
        String s1 = BufferedInputFile.read("FileOutputShortcut.java");
        StringReader stringReader = new StringReader(s1);
        BufferedReader in = new BufferedReader(stringReader);
        // Here’s the shortcut:
        PrintWriter out = new PrintWriter(file); //PrintWriter有直接传入文件名的构造器，内部其实仍然是用文件流和处理流封装过的
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null )
            out.println(lineCount++ + ": " + s);
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
}
