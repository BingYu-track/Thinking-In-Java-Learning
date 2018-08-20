package strings;

import innerclasses.multiextends.Z;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description: 边界匹配器^和$
 * @author: hxw
 * @date: 2018/8/20 13:13
 */
public class BorderMacher2 {

    @Test
    public void test(){
        //^和$的用法
        String a = "31316sasfasd6".replaceAll("\\d{2}", "Z");  //将两个数字替换Z
        System.out.println(a);//ZZsasfasd

        String b = "3131sasfasd".replaceAll("^\\d{2}", "Z");//仅替换字符串开头的两个数字为Z
        System.out.println(b);//Z31sasfasd

        String c = "3131sdasfasd".replaceAll("sd", "Z");
        System.out.println(c);//3131ZasfaZ

        String d = "3131sdsfasd".replaceAll("sd$", "Z");//仅替换字符串开头的两个数字
        System.out.println(d);//3131sdsfaZ

        String e = "sd3131sdsfasd".replaceAll("^sd$", "Z");
        System.out.println(e); //3131sdsfasd

        String str6 = "31";
        System.out.println(str6.matches("\\d{2}")); //false
        System.out.println(str6.matches("^\\d{2}"));//false

}

    @Test
    public void test1(){
        String regex = "^1\\d{10}$";
        String regex1 = "1\\d{10}";
        String s1 = "小明手机18311131865".replaceAll(regex, "Z");
        String t1 = "小明手机18311131865".replaceAll(regex1, "Z");
        System.out.println("使用了^和&:"+s1); //小明手机18311131865
        System.out.println(t1); //小明手机Z

        String s2 = "18311131865小明手机18311131865".replaceAll(regex, "Z");
        String t2 = "18311131865小明手机18311131865".replaceAll(regex1, "Z");
        System.out.println("使用了^和&: "+s2); //18311131865小明手机18311131865
        System.out.println("t2: "+t2); //Z小明手机Z
        System.out.println("18311131865".matches(regex)); //true 整体匹配
        //这个示例证明了同时使用了^和&,那么该正则会严格将其锁定匹配即整体匹配，而不会部分匹配
    }
    //总结：^和$相当于将模式要匹配的位置给锁定了，只会匹配开头或结尾;如果同时使用了^和&，表示整体匹配
}
