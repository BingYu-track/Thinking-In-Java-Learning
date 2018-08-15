package strings;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description: Stringz.split(String regex) 将字符串从正则表达式匹配的地方切开
 * @author: hxw
 * @date: 2018/8/7 22:27
 */
public class Splitting {
    public static String knights = "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " + "with... a herring!";
    public static void split(String regex) {
        String[] splitd = knights.split(regex);
        System.out.println(Arrays.toString(splitd));
    }
    public static void main(String[] args) {
        split(" "); // Doesn’t have to contain regex chars
        split("\\W+"); // \W表示非单词字符,表示从非单词字符切开(并会移除非单词字符)
        split("n\\W+"); // 字母n后面跟着一个或多个非单词字符
    }
}
