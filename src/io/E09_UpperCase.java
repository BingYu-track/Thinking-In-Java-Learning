package io;

import java.util.List;
import java.util.ListIterator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/15 16:52
 */
public class E09_UpperCase {

    public static void main(String[] args) throws java.io.IOException {
        if(args.length != 1) {
            System.err.println("Usage: java E09_UpperCase file");
            return;
        }
        List<String> list = E07_FileIntoList.read(args[0]);
        for(ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious();){
            System.out.println(it.previous().toUpperCase());
        }
    }

}
