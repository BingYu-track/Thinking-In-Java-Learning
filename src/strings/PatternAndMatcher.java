package strings;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description: String.matches()  Pattern.matches(regex,input) 和Pattern.compile(regex).matcher(input).find()
 * @author: hxw
 * @date: 2018/8/18 16:41
 */
public class PatternAndMatcher {

    @Test
    public void test(){
        String regex = "\\[.+\\]\\[.+\\]";
        String regex1 = ".+\\[.+\\]\\[.+\\].+\\[.+\\]\\[.+\\].+\\[.+\\]\\[.+\\].+"; //regex1符合字符串str整体匹配
        String str = "This is [google][1],this is [apple][2],and this is [ms][3],";

        /*1.这里matches方法指的是全部匹配而不是部分匹配，是将整个输入串str与模式匹配regex，如果要验证一个输入的数据是否为数字类型或其他类型，一般要用matches()
           等价于Pattern.compile(regex).matcher(input).matches()。
          2.find()方法是部分匹配，是查找输入串中与模式匹配的子串
        */
        boolean t = Pattern.matches(regex, str);
        boolean t1 = str.matches(regex1);  //String.matches()
        boolean t2 = Pattern.matches(regex1, str); //Pattern.matches(regex,input)
        System.out.println("t:"+t); //false  因为Pattern.matches(regex,input)是整个匹配，明显regex正则不匹配。regex1则匹配
        System.out.println("str.matches:"+t1+"; Pattern.matches:"+t2); //str1.matches:true; Pattern.matches:true
        /*从上面例子知道String.matches()与Pattern.matches(regex,input)和Pattern.compile(regex).matcher(input).matches()等效
         都是全部匹配。
        */
    }
}
