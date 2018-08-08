package strings.exercise;

import strings.Splitting;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/8 7:53
 */
public class E09_Replacing2 {

    public static void main(String[] args){
        //(?i)启用不区分大小写的匹配
        System.out.println(Splitting.knights.replaceAll("(?i)[aeiou]","_"));
        System.out.println(Splitting.knights.replaceAll("[aeiou]","_"));
    }
}
