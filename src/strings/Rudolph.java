package strings;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/9 22:30
 */
public class Rudolph {
    public static void main(String[] args) {
        for(String pattern : new String[]{ "Rudolph","[rR]udolph", "[rR][aeiou][a-z]ol.*", "R.*" }){
            System.out.println("Rudolph".matches(pattern));
        }
    }
}
