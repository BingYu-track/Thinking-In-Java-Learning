package net.mindview.util;

import java.io.*;
import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/6/19 23:50
 */
public class TextFile extends ArrayList<String> {
    // Read a file as a single string: 读取文件并将信息临时保存到字符串中
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in= new BufferedReader(
                                new FileReader(
                                    new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    // Write a single file in one method call:在一个方法调用中写入单个文件

    /**
     *
     * @param fileName 要写入的文件名
     * @param text 要写入的内容
     */
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Read a file, split by any regular expression:
    public TextFile(String fileName, String splitter) {
        //String read = read(fileName); //读取文件信息
        //String[] split = read.split(splitter); //以参数符号分割字符串
        //Arrays.asList(split) 将分割后的数组转化为list
        super(Arrays.asList(read(fileName).split(splitter))); //里面的代码不能分开，因为super必须在第一个执行
        // Regular expression split() often leaves an empty String at the first position:正则表达式Split()通常在第一个位置留下一个空字符串：
        if(get(0).equals("")) remove(0);
    }

    // Normally read by lines:
    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    //将自身的信息写入文件中
    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                for(String item : this)
                    out.println(item);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Simple test:
    public static void main(String[] args) {
        String file = read("TextFile.java");
        write("test.txt", file); //将TextFile.java文件中的所有内容写入test.txt
        TextFile text = new TextFile("test.txt");
        text.write("test2.txt"); //再将test.txt里的内容写入test2.txt
        // Break into unique sorted list of words:
        TreeSet<String> words = new TreeSet<String>(new TextFile("TextFile.java", "\\W+"));
        // Display the capitalized words:
        System.out.println(words.headSet("a")); //返回小于a的元素
    }
}
