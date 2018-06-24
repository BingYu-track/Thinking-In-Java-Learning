package holding.exercise;

import net.mindview.util.TextFile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/6/24 20:11
 */
public class E16_Vowels {

    private final static Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'o', 'u',
                    'i', 'A', 'E', 'O', 'U', 'I'));

    public static void main(String[] args){
        HashSet<String> processedWords = new HashSet<String>();
        int fileVowels = 0;
        int wordVowels;
        for(String word : new TextFile("D:\\Eclipse_Code\\ThinkInJava\\src\\holding\\exercise\\E16_Vowels.java", "\\W+")) {
            //获取单词
            wordVowels = 0;
            for(char letter : word.toCharArray()){ //单词划分成一个个字母
                if(vowels.contains(letter))
                    wordVowels++;
            }
            if(!processedWords.contains(word)) {
                processedWords.add(word);
                System.out.println(word + " has " + wordVowels + " vowel(s)");
            }
            fileVowels += wordVowels;
        }
        System.out.println("Total number of vowels in file: " + fileVowels);
    }
}
