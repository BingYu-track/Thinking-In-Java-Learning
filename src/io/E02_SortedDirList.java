package io;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/13 14:34
 */
public class E02_SortedDirList {

    public static void main(String[] args){
        SortedDirList dir = new SortedDirList();
        System.out.println(Arrays.toString(dir.list("E0[12]_.*\\.java"))); // [12]表示1或2
        //[E01_SearchWords.java, E02_SortedDirList.java]
    }
}
