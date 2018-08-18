package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/18 22:42
 */
public class MatcherTest {

    public static void main(String[] args){
        Pattern pattern = Pattern.compile("\\d{3,5}"); //正则表示：数字至少出现3次，但不能超过5次
        String charSequence = "123-34345-234-00";
        Matcher matcher = pattern.matcher(charSequence);

        //虽然匹配失败，但由于charSequence里面的"123"和pattern是匹配的,所以下次的匹配从位置4开始
        print(matcher.matches());
        //测试匹配位置
        matcher.find();
        print(matcher.start());

        //使用reset方法重置匹配位置
        matcher.reset();

        print(matcher.find());
        print("第一次find匹配以及匹配的目标和匹配的起始位置: "+matcher.group()+" - "+matcher.start());
        print(matcher.find());
        print("第二次find匹配以及匹配的目标和匹配的起始位置: "+matcher.group()+" - "+matcher.start());

        print(matcher.lookingAt());
        print("第一次lookingAt匹配以及匹配的目标和匹配的起始位置: "+matcher.group()+" - "+matcher.start());

        print(matcher.lookingAt());
        print("第二次lookingAt匹配以及匹配的目标和匹配的起始位置: "+matcher.group()+" - "+matcher.start());

        //使用reset方法重置匹配位置
        matcher.reset();
        //遍历所有匹配的子串
        while(matcher.find()){
            print(matcher.group()+" - "+matcher.start());
        }


    }
    public static void print(Object o){
        System.out.println(o);
    }
}
