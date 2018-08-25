package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description: matcher.reset()方法
 * @author: hxw
 * @date: 2018/8/25 23:37
 */
public class Resetting {

    public static void main(String[] args){
        Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
        while(m.find()){
            System.out.print(m.group() + " ");
        }
        System.out.println();
        m.reset("fix the rig with rags");
        //reset()方法，将Matcher对象重新设置到当前字符串的起始位置；如果加参数reset(CharSequence input)，就是讲Matcher对象重新设置到input字符串的开始位置
        //本例是将Matcher设置到"fix the rig with rags"字符串的起始位置
        while(m.find()){
            System.out.print(m.group() + " ");
        }
    }
}
