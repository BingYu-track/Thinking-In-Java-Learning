package containers;

import net.mindview.util.TextFile;

import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/5 20:01
 */
public class E13_WordCounter {

    public static void main(String[] args) {
        List<String> words = new TextFile("D:\\Eclipse_Code\\ThinkInJava\\src\\containers\\E12_MapsDemo.java", "\\W+");
        AssociativeArray2<String, Integer> map = new AssociativeArray2<String, Integer>(words.size());
        for(String word : words) {
            Integer freq = map.get(word);
            map.put(word, freq == null ? 1 : freq + 1);
        }
        System.out.println(map);
    }

}

