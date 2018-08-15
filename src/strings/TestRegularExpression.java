package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/9 22:55
 */
public class TestRegularExpression {
    public static void main(String[] args) {
        //args = new String[]{"abcabcabcdefabc", "abc+", "(abc)+","(abc){2,}" }; //贪婪型
        //args = new String[]{"abcabcabcdefabc", "abc+", "(abc)+?","(abc){2,}" }; //勉强型
        args = new String[]{"abcabcabcdefabc", "abc+", "(abc)++","(abc){2,}" }; //占有型
        if(args.length < 2) {
            System.out.println("Usage:\njava TestRegularExpression " + "characterSequence regularExpression+");
            System.exit(0);
        }
        System.out.println("Input: \"" + args[0] + "\"");
        /*for(String arg : args) {
            System.out.println("Regular expression: \"" + arg + "\"");
            Pattern p = Pattern.compile(arg); //编译正则
            Matcher m = p.matcher(args[0]); //要检索的字符串
            while(m.find()) { //尝试用该匹配模式对"要检索的字符串"进行下一次匹配，匹配成功返回true，否则返回false
                System.out.println("Match \"" + m.group() +  //
                        "\" at positions " +  m.start() +  //返回这次匹配的初始索引
                        "-" + (m.end() - 1)); //返回这次匹配最后一个字符的偏移量(如果想要的是索引，如示例需要减1)
            }
        }*/
        System.out.println("Regular expression: \"" + args[2] + "\"");
        Pattern p = Pattern.compile(args[2]);
        Matcher m = p.matcher(args[0]);
        while(m.find()) {
            System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
        }
    }
}
