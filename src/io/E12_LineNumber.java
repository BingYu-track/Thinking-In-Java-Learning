package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/20 14:41
 */
public class E12_LineNumber {
    //{Args: E12_LineNumber.java E12_LineNumber.out}
    public static void main(String[] args) throws IOException {
        if(args.length != 2) {
            System.err.println("Usage: java E12_LineNumber infile outfile");
            return;
        }
        List<String> list = E07_FileIntoList.read(args[0]);
        PrintWriter out = new PrintWriter(
                            new BufferedWriter(
                                new FileWriter(args[1])));
        // We need to count backwards...
        int line = list.size();
        for(ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious();){
            out.println(line-- + ": " + it.previous());
        }
        out.close();
    }
}
