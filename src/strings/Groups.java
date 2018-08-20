package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static net.mindview.util.Print.*;
/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/19 23:00
 */
public class Groups {
    static public final String POEM = "Twas brillig, and the slithy toves\n" +
                                        "Did gyre and gimble in the wabe.\n" +
                                        "All mimsy were the borogoves,\n" +
                                        "And the mome raths outgrabe.\n\n" +
                                        "Beware the Jabberwock, my son,\n" +
                                        "The jaws that bite, the claws that catch.\n" +
                                        "Beware the Jubjub bird, and shun\n" +
                                        "The frumious Bandersnatch.";
    public static void main(String[] args) {
        /*
        1）(?m)表示按照多行模式每次提取一行进行匹配；
        2）\S+表示匹配一个或多个非空白符；
        3）\s+表示匹配一个或多个空白符（包括空格、tab、换行、换页和回车）；
        4）$表示从靠近行尾的地方取数据，表示一行的末尾。
        */
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
        while(m.find()) {
            for(int j = 0; j <= m.groupCount(); j++){
                printnb("[" + m.group(j) + "]");
             }
            print();
        }
    }
}
