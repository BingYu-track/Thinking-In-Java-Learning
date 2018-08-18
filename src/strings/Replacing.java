package strings;

/**
 * @version 1.0
 * @Description: 替换
 * @author: hxw
 * @date: 2018/8/8 7:30
 */
public class Replacing {
    static String s = Splitting.knights;
    public static void main(String[] args) {
        System.out.println(s);
        //执行结果：Then, when you have found the shrubbery, you must cut down the mightiest tree in the forest... with... a herring!

        //匹配以f开头，后面跟一个或多个字母，并只替换掉第一个匹配的部分(注意这里w是小写)
        String s1 = s.replaceFirst("f\\w+", "located");
        //执行结果：Then, when you have located the shrubbery, you must cut down the mightiest tree in the forest... with... a herring!
        System.out.println(s1);

        //匹配shrubbery，tree或herring三个单词，并全部替换掉
        String s2 = s.replaceAll("shrubbery|tree|herring","banana");
        //执行结果：Then, when you have found the banana, you must cut down the mightiest banana in the forest... with... a banana!
        System.out.println(s2);
    }
}
