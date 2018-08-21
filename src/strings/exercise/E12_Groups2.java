package strings.exercise;

import strings.Groups;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description: 找出不以大写字母开头的词，并且不重复的计算个数
 * @author: hxw
 * @date: 2018/8/21 8:48
 */
public class E12_Groups2 {
    public static void main(String[] args) {
        Set<String> words = new HashSet<String>();
        Matcher m = Pattern.compile("\\b((?![A-Z])\\w+)\\b").matcher(Groups.POEM);
        while(m.find()){
            words.add(m.group(1));
        }
        print("Number of unique words = " + words.size());
        print(words.toString());
        /*
            Number of unique words = 25
[raths, mimsy, mome, gimble, that, claws, brillig, son, gyre, and, borogoves, bite, bird, catch, shun, toves, jaws, in, outgrabe, my, the, slithy, were, wabe, frumious]
        */
    }
}
