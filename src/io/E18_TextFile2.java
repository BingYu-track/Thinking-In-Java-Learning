package io;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;

import java.io.IOException;
import java.util.TreeSet;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/21 18:55
 */
public class E18_TextFile2 {

    public static void main(String[] args) throws IOException {
        String file = TextFile2.read("E18_TextFile2.java");
        TextFile2.write("test.txt", file);
        TextFile2 text = new TextFile2("test.txt");
        text.write("test2.txt");
        // Break into unique sorted list of words:
        TreeSet<String> words = new TreeSet<String>(new TextFile2("E18_TextFile2.java", "\\W+"));
        // Display the capitalized words:
        System.out.println(words.headSet("a"));
    }

}
