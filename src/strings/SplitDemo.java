package strings;

import java.util.Arrays;
import java.util.regex.Pattern;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/25 18:25
 */
public class SplitDemo {

    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        print(Arrays.toString(Pattern.compile("!!").split(input))); //[This, unusual use, of exclamation, points]
        // Only do the first three:
        print(Arrays.toString(Pattern.compile("!!").split(input, 3))); //[This, unusual use, of exclamation!!points] 限制了分割后数组的长度
    }
}
