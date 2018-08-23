package strings.exercise;

import org.junit.Test;
import strings.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static net.mindview.util.Print.*;
import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description: 找出不以大写字母开头的词，并且不重复的计算个数
 * @author: hxw
 * @date: 2018/8/21 8:48
 */
public class E12_Groups2 {
    static public final String POEM = "Twas brillig, and the slithy toves\n" +
                                    "Did gyre and gimble in the wabe.\n" +
                                    "All mimsy were the borogoves,\n" +
                                    "And the mome raths outgrabe.\n\n" +
                                    "Beware the Jabberwock, my son,\n" +
                                    "The jaws that bite, the claws that catch.\n" +
                                    "Beware the Jubjub bird, and shun\n" +
                                    "The frumious Bandersnatch.";
    //  \\b((?![A-Z])\w+)\\b
    public static void main(String[] args) {
        Set<String> words = new HashSet<>(); //存储所有匹配的子串，但是去重
        ArrayList<String> list = new ArrayList<>();  //存储所有匹配的子串
        //Matcher m = Pattern.compile("\\b(([^A-Z])\\w+)\\b").matcher(E12_Groups2.POEM);
        Matcher m = Pattern.compile("\\b((?![A-Z])\\w+)\\b").matcher(E12_Groups2.POEM);
        while(m.find()){
            words.add(m.group());
            list.add(m.group(1));
        }
        print("Number of unique words = " + words.size()); //不重复的个数，因此需要用到HashSet用来过滤重复数据
        print(list);
        print(words.toString());
        /* (?![A-Z])表示当前位置不能为大写字母
            Number of unique words = 25
List:[brillig, and, the, slithy, toves, gyre, and, gimble, in, the, wabe, mimsy, were, the, borogoves, the, mome, raths, outgrabe, the, my, son, jaws, that, bite, the, claws, that, catch, the, bird, and, shun, frumious]
Set:[raths, mimsy, mome, gimble, that, claws, brillig, son, gyre, and, borogoves, bite, bird, catch, shun, toves, jaws, in, outgrabe, my, the, slithy, were, wabe, frumious]

          ([^A-Z])
          [ brillig, and,  the,  slithy,  toves,
          Did,  gyre,  and,  gimble,  in,  the,  wabe,  mimsy,  were,  the,  borogoves,  the,  mome,  raths,  outgrabe,  the,  Jabberwock, my,  son,  jaws,  that,  bite, the,  claws,  that,  catch,  the,  Jubjub,  bird, and,  shun,
          The,  frumious,  Bandersnatch]

          注意：\\b((?![A-Z])\\w+)\\b  这里(?![A-Z])\\w+中的(?![A-Z])是对后面的\\w+做限制，因为\\w是单词，又加了(?![A-Z])这个限制意思就成了
                不能是大写字母；而\\b(([^A-Z])\\w+)\\b这个表达式([^A-Z])\\w+仅仅表示的是非大写字母的任何字符加上单词，两个正则表达式的意思就完全不一样了。
        */
    }

    //环视（断言/零宽断言）
    @Test
    public void test(){
        System.out.println("a".matches("([^A-Z])")); //true
        System.out.println("a".matches("([^A-Z])\\w+")); //false 因为正则这里需要两个字符
        System.out.println("a".matches("(?![A-Z])\\w+")); //true
        System.out.println("".matches("(?![A-Z])")); //true  这个结论说明，(?!x)并不占有一个位置

        //重要：看到(?!B)[A-Z]这种写法，其实它是[A-Z]范围里，排除B的意思，前置的(?!B)只是对后面数据的一个限定，从而达到过滤匹配的效果。
    }
}
