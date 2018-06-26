package holding.exercise;

import net.mindview.util.TextFile;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/6/26 7:38
 */
public class E21_WordsInfo {

    public static void main(String[] args) {
        Map<String,Integer> wordsStat = new HashMap<String,Integer>(); //存储单词出现的次数
        for(String word : new TextFile("D:\\Eclipse_Code\\ThinkInJava\\src\\holding\\exercise\\E21_WordsInfo.java", "\\W+")) {
            Integer freq = wordsStat.get(word);
            wordsStat.put(word, freq == null ? 1 : freq + 1);
        }
        List<String> keys = new ArrayList<String>(wordsStat.keySet()); //获取所有单词构成的List
        //对单词集合进行排序
        Collections.sort(keys, String.CASE_INSENSITIVE_ORDER); //String.CASE_INSENSITIVE_ORDER得到一个对 String 对象进行排序的Comparator
        for(String key : keys){
            System.out.println(key + " => " + wordsStat.get(key));
        }
    }
}
