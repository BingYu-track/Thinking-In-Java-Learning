package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/15 16:37
 */
public class E07_FileIntoList {

    //读取文件每一个行作为字符串，放入LinkedList中
    public static List<String> read(String filename) throws IOException{
        LinkedList<String> list = new LinkedList<>();
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        //StringBuilder sb = new StringBuilder();
        while ((s=in.readLine())!=null){
            list.add(s);
        }
        in.close();
        return list;
    }

    public static void main(String[] args) throws IOException {
        List<String> list = read("E07_FileIntoList.java");
        ListIterator<String> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }
}
