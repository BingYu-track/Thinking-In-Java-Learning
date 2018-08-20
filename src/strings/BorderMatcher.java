package strings;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description: 单词边界\b与非单词边界\B
 * @author: hxw
 * @date: 2018/8/19 21:06
 */
public class BorderMatcher {

    public static void main(String[] args) {
        String str="(中文问号？123???英文)问号?我是华丽[的制表符\t]我是华丽{的空格符 我是华丽}的换行符\n";
        String rex="\\b";

        Pattern pattern=Pattern.compile(rex);
        Matcher matcher=pattern.matcher(str);

        String [] result=pattern.split(str);
        System.out.println(Arrays.toString(result)); //[(, 中文问号, ？, 123, ???, 英文, ), 问号, ?, 我是华丽, [, 的制表符, 	], 我是华丽, {, 的空格符,  , 我是华丽, }, 的换行符,]
        //从这些分割的字符串中我们可以知道单词边界就是单词和符号之间的边界，例如在"(中文问号"这个字符串中，\b匹配的就是"("与"中"之间的东西
        //这里的单词可以是中文字符,英文字符,数字；符号可以是中文符号,英文符号,空格,制表符,换行
    }

    /**
     * 单词边界匹配 \b
     */
    @Test
    public void test1(){
        String str=" 2 "; //注意：空格并不是边界是符号，空格与数字2之间的东西才叫边界，这里很明显不符合整体匹配
        //String str="2"; //改成这样就可以匹配上了
        String rex="\\b2\\b";
        boolean flag = str.matches(rex);
        System.out.println(flag); //false
    }

    /**
     * 非单词边界匹配 \B  --理解：\b是单词与符号的边界 那非单词与符号的边界的其它都是\B，即\B是符号与符号,单词与单词的边界
     */
    @Test
    public void test2(){
        String str="123456我是JAVA{,、;‘asd";
        String rex="\\B";

        Pattern pattern=Pattern.compile(rex);
        Matcher matcher=pattern.matcher(str);
        String [] result=pattern.split(str);

        for(String string:result){
            System.out.println("分割的字符串:"+string);
        }
        /*
            分割的字符串:1
            分割的字符串:2
            分割的字符串:3
            分割的字符串:4
            分割的字符串:5
            分割的字符串:6
            分割的字符串:我
            分割的字符串:是
            分割的字符串:J
            分割的字符串:A
            分割的字符串:V
            分割的字符串:A{
            分割的字符串:,
            分割的字符串:、
            分割的字符串:;
            分割的字符串:‘a
            分割的字符串:s
            分割的字符串:d
        */
    }
}
