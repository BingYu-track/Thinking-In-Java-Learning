package io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/21 18:53
 */
public class TextFile2 extends ArrayList<String> {

    // Read a file as a single string:
    public static String read(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in= new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
        try {
            String s;
            while((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } finally {
            in.close();
        }
        return sb.toString();
    }

    // Write a single file in one method call:
    public static void write(String fileName, String text) throws IOException {
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(
                        new File(fileName).getAbsoluteFile())));
        try {
            out.print(text);
        } finally {
            out.close();
        }
    }

    // Read a file, split by any regular expression:
    public TextFile2(String fileName, String splitter) throws IOException {
        super(Arrays.asList(read(fileName).split(splitter)));
        // Regular expression split() often leaves an empty String at the first position:
        if(get(0).equals("")) remove(0);
    }

    // Normally read by lines:
    public TextFile2(String fileName) throws IOException {
        this(fileName, "\n");
    }

    public void write(String fileName) throws IOException {
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(
                        new File(fileName).getAbsoluteFile())));
        try {
            for(String item : this)
                out.println(item);
        } finally {
            out.close();
        }
    }

}
