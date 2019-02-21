package io;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import net.mindview.util.TextFile;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/21 18:36
 */
public class E17_CharactersInfo {

    public static void main(String[] args){
        Map<Character,Integer> charsStat = new HashMap<Character,Integer>();
        for(String word : new TextFile("E17_CharactersInfo.java", "\\W+")){ //遍历每个单词
            //遍历单词的字母，并将其所有的字母和其使用频率放入charsStat中
            for(int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                Integer freq = charsStat.get(ch);
                charsStat.put(ch, freq == null ? 1 : freq + 1);
            }
        }
        List<Character> keys = Arrays.asList(charsStat.keySet().toArray(new Character[0]));
        Collections.sort(keys); //字母排序
        for(Character key : keys){
            System.out.println(key + " => " + charsStat.get(key));
        }
    }

}
