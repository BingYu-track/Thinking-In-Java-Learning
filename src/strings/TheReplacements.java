package strings;
import net.mindview.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/25 19:38
 */
public class TheReplacements {

    public static void main(String[] args){
        String s = TextFile.read("D:\\Eclipse_Code\\ThinkInJava\\src\\strings\\TheReplacements.java");
        System.out.println("读取的原始文本："+s);
        // Match the specially commented block of text above: 匹配上面特别注释的文本块：
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s); //编译正则并启用单行模式
        if(mInput.find()){
            s = mInput.group(1); // Captured by parentheses 获取第一个捕获组
        }

        System.out.println("----------------------------");
        // Replace two or more spaces with a single space: 用单个空格替换两个或多个空格：
        s = s.replaceAll(" {2,}", " ");
        System.out.println("单个空格替换两个或多个空格后:"+s);


        System.out.println("---------------------------------");
        // Replace one or more spaces at the beginning of each line with no spaces. Must enable MULTILINE mode:
        //将每行开头的一个或多个空格替换为无空格。必须启用多行模式，因为多行模式下^就能匹配每行的开头，而不启用多行模式则将整个看做一行
        s = s.replaceAll("(?m)^ +", "");
        print("将每行开头的一个或多个空格替换为无空格:" + s);

        System.out.println("----------------------------");
        s = s.replaceFirst("[aeiou]", "(VOWEL1)"); //只替换开头
        System.out.println("将开头的元音字母替换(VOWEL1)："+s);

        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        // Process the find information as you perform the replacements: 在执行替换时处理查找信息
        while(m.find()){
            m.appendReplacement(sbuf, m.group().toUpperCase()); //
        }
        /*appendReplacement(sb, replaceContent)方法：sb是一个StringBuffer，replaceContext待替换的字符串，
        这个方法会把匹配到的内容替换为replaceContext，本例是将当前Matcher.find匹配的地方用m.group().toUpperCase()代替 并且把从上次替换的位置到这次替换位置之间的字符串也拿到，
        然后，加上这次替换后的结果一起追加到StringBuffer里（假如这次替换是第一次替换，那就是只追加替换后的字符串啦）。*/
        System.out.println(sbuf);
        // Put in the remainder of the text:
        m.appendTail(sbuf); //appendTail这个方法是把最后一次匹配到内容之后的字符串追加到StringBuffer中。
        print(sbuf);
    }
}
