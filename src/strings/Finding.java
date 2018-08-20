package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/19 22:12
 */
public class Finding {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+").matcher("Evening is full of the linnet’s wings");
        while(m.find()){
            printnb(m.group() + " ");
        }
        print();
        int i = 0;
        while(m.find(i)) { //find(i)表示以i索引为匹配的起始位置匹配
            printnb(m.group() + " index:"+i);
            i++;
        }
    }
}
