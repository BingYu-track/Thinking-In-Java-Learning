package holding.exercise;

import net.mindview.util.TextFile;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/6/24 23:48
 */
public class E20_VowelsInfo {

    private final static Set<Character> vowels =
            new HashSet<Character>(Arrays.asList('a', 'e', 'o', 'u','i', 'A', 'E', 'O', 'U', 'I'));
    static void updateStat(Map<Character,Integer> stat, char letter) {
        Character ch = Character.toLowerCase(letter); //将字符转为小写
        Integer freq = stat.get(ch); //查看map中是否有该字符
        stat.put(ch, freq == null ? 1 : freq + 1); //如果是null说明是第一次出现，映射为1，否则再之前的基础上加1
    }

    public static void main(String[] args) {
        HashMap<Character,Integer> fileStat = new HashMap<Character,Integer>();  //记录元音字母在整个文件的出现次数
        HashSet<String> processedWords = new HashSet<String>();
        HashMap<Character,Integer> wordStat = new HashMap<Character,Integer>(); //记录元音字母在每个单词出现的次数
        for(String word : new TextFile("D:\\Eclipse_Code\\ThinkInJava\\src\\holding\\exercise\\E20_VowelsInfo.java", "\\W+")) {
            wordStat.clear(); //清空
            for(char letter : word.toCharArray()){ //单词转化为char数组
                if(vowels.contains(letter)) {
                    updateStat(wordStat, letter);
                    updateStat(fileStat, letter);
                }
            }
            if(!processedWords.contains(word)) {
                processedWords.add(word);
                System.out.println("Vowels in " + word + ": " + wordStat);
            }
        }
        System.out.println("*************************");
        System.out.println("Vowels in the whole file: " + fileStat);
    }
}
