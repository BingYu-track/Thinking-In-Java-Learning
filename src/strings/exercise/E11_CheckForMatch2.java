package strings.exercise;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/19 19:32
 */
public class E11_CheckForMatch2 {
    public static void main(String[] args){
        //第一个捕获组是忽略大小写;第二个捕获组是除非元音字母的任何字符，或者是一个或多个空白符加上元音字母。
        //第三组是多个单词字符(勉强型) + 一个元音字母 + 单词边界
        Pattern p = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
        String source = "Arline ate eight apples and " + "one orange while Anita hadn't any";
        Matcher m = p.matcher(source);
        System.out.println(source); //Arline ate eight apples and one orange while Anita hadn't any
        while(m.find()) {
            System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
        }
    }

}
