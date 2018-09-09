package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description: Pattern和Matcher的toString方法
 * @author: hxw
 * @date: 2018/9/7 8:22
 */
public class PatternAndMatcherToString {

    public static void main(String[] args){
        String str = "public static void typeinfo.ShowMethods.main(java.lang.String[])";
        Pattern p = Pattern.compile("\\w+\\.");
        System.out.println(p); //  \w+\.
        Matcher matcher = p.matcher(str);
        System.out.println(matcher.replaceAll("")); //等同于 String s = str.replaceAll("\\w+\\.", "");
    }
}
