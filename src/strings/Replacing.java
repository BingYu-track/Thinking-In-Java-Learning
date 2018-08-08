package strings;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/8 7:30
 */
public class Replacing {
    static String s = Splitting.knights;
    public static void main(String[] args) {
        System.out.println(s);
        System.out.println(s.replaceFirst("f\\w+", "located")); //替换掉以f开头，后面跟一个或多个字母并只替换第一个匹配的
        System.out.println(s.replaceAll("shrubbery|tree|herring","banana"));
    }
}
