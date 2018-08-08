package strings.exercise;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/8 7:38
 */
public class E07_SentenceChecker {
    public static boolean matches(String text) {
        //以大写字母开头，以句号结尾
        return text.matches("\\p{javaUpperCase}.*\\.");
    }
    public static void main(String[] args) {
        System.out.println(matches("This is correct."));
        System.out.println(matches("bad sentence 1."));
        System.out.println(matches("Bad sentence 2"));
        System.out.println(matches("This is also correct..."));
    }
}
