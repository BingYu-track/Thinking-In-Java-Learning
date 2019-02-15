package io;

import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/15 17:03
 */
public class E10_FindWords {

    /*public static void main(String[] args) throws java.io.IOException {
        if(args.length != 2) {
            System.err.println("Usage: java E08_CommandLine file");
            return;
        }
        List<String> list = E07_FileIntoList.read(args[0]);
        for(ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious();){
            String line = it.previous();
            if(line.contains(args[1])){
                System.out.println(line);
            }
        }
    }*/

    public static void main(String[] args) throws java.io.IOException {
        if(args.length < 2) {
            System.err.println("Usage: java E10_FindWords file words");
            return;
        }
        Set<String> words = new HashSet<String>();
        //用HashSet去除附加命令中重复的字符串
        for(int i = 1; i < args.length; i++){
            words.add(args[i]);
        }
        List<String> list = E07_FileIntoList.read(args[0]);
        for(ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious();) {
            String candidate = it.previous();
            for(String word : words){ //遍历要查找的单词
                if(candidate.contains(word)) { //判断该行文本是否包含word，注意这里使用indexOf()而不是使用contains()
                    System.out.println(candidate);
                    break;
                }
            }
        }

    }

}
