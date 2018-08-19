package strings.exercise;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/19 17:22
 */
public class E10_CheckForMatch {
    public static void main(String[] args) {
        String source = "Java now has regular expressions";
        String[] regEx = {"^Java", "\\Breg.*", "n.w\\s+h(a|i)s", "s?", "s*", "s+", "s{4}", "s{1}.", "s{0,3}"};
        System.out.println("Source string: " + source);
        for(String pattern : regEx) {
            System.out.println("Regular expression: \"" + pattern + "\"");
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(source);
            while(m.find()) {
                System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
            }
        }
    }

    @Test
    public void test(){
        String source = "Java now has regular expressions";
        String regex = "s*";
        System.out.println("".matches(regex)); //注意除了s,就只有空字符串能匹配了，那是因为*不匹配任意字符，*只是一个限定符，限定重复次数
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(source);
        while(m.find()) {
            System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
        }
        //注意对于m.group()方法，某些模式（例如，a*）匹配空字符串。当模式成功匹配输入中的空字符串时，此方法将返回空字符串
        //m.group()与s.substring(m.start(), m.end())等效 m.start() - 起始索引（包括）。m.end() - 结束索引（不包括）。
    }
}
