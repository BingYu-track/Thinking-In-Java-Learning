package strings;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description: 正则表达式量词，贪婪型和勉强型以及占有型对比
 * @author: hxw
 * @date: 2018/8/16 22:34
 */
public class RegularMeasurTest {
    @Test
    public void test1(){
        String str="<aaa<bbb>ccc<ddd>eee>";
        /*执行结果：####  贪婪型--匹配尽量多的字符，这里aaa<bbb>ccc<ddd>eee匹配正则的.+;
        原理：开始正则的<匹配字符串<,.+匹配第一个<后面的所有字符，但是发现正则后面还有一个>没有匹配，因此它会会进行回溯，回退
        缩小范围直到匹配成功。
         */
        System.out.println(str.replaceAll("<.+>","####"));

        /*执行结果：####ccc####eee>  勉强型--从左到右.+尽可能匹配最少的字符(即从左向右查找过程中只要遇到一个可以匹配的结果就输出)
           这里 <aaa<bbb> 以及<ddd>匹配
         */
        System.out.println(str.replaceAll("<.+?>","####"));

        /*执行结果：<aaa<bbb>ccc<ddd>eee>  占有型--和贪婪型一样，匹配尽量多的字符，唯一不同的是占有型不支持回溯
          在这里正则的<字符串<，.+匹配第一个<后面的所有字符，由于不支持回溯，因此这个时候没有字符与>匹配，整个正则也就不匹配
        */
        System.out.println(str.replaceAll("<.++>","####"));
        System.out.println(str.replaceAll("<d++>","####")); //<aaa<bbb>ccc####eee>
    }

    @Test
    public void test2(){
        //由于正则表达式中[]具有特殊含义，因此需要用反斜杠转义
        String p = "\\[.+\\]\\[.+\\]";
        String str = "This is [google][1],this is [apple][2],and this is [ms][3].";
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            System.out.println("当前匹配子串: "+ matcher.group()+"; 开始位置: "+matcher.start()+"; 结束位置: "+matcher.end());
            //贪婪型--当前匹配子串: [google][1],this is [apple][2],and this is [ms][3]; 开始位置: 8; 结束位置: 58
        }
    }
    /*
    Pattern pattern_tanlan="\\w+\\w";
    Pattern pattern_zhanyou="\\w++\\w";
    以上分别是贪婪型和占有型，面对这样的源字符串："This is [google][1],this is [apple][2],and this is [ms][3]."
    贪婪型可以成功find出：“This”,"is","google","this","is","apple","and","this","is","ms"这些子串，
    而占有型则一个也没有。因为匹配\\w时,它们都是尽量往后匹配，以This为例，都匹配到了字母s，可是空格就无法匹配了，
    然后pattern_tanlan后头的\\w无法匹配，它就回溯，最终让后一个\\w匹配s，而\\w+匹配Thi，但是占有型则不，它不回溯，也就一个也匹配不成了。
    */
}
