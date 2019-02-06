package containers;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import net.mindview.util.TextFile;

import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/6 20:13
 */
public class E15_WordCounter2 {

    public static void main(String[] args) {
        List<String> words = new TextFile("D:\\Eclipse_Code\\ThinkInJava\\src\\containers\\E12_MapsDemo.java", "\\W+");
        SlowMap<String,Integer> map = new SlowMap<String,Integer>();
        for(String word : words) {
            Integer freq = map.get(word);
            map.put(word, freq == null ? 1 : freq + 1);
        }
        System.out.println(map);
    }
}
