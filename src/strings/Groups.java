package strings;

import org.junit.Test;

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
        (?m)(\S+)\s+((\S+)\s+(\S+))$：取靠近行尾的数据形式：（数据）空白字符（（数据）空白字符（数据））结尾 意即捕获每行的最后3个词。
        (?m)\S+\s+\S+\s+\S+$这样不加括号也是表示匹配每行的最后三个词，只是这里为了介绍捕获组的方法而加上括号
        */
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
        while(m.find()) {
            for(int j = 0; j <= m.groupCount(); j++){
                System.out.println(m.group()); //始终返回当前find()时匹配的子串，第0组(即整体匹配)，比如第一行匹配的就是"the slithy toves"
                printnb("[" + m.group(j) + "]");
             }
            print();
        }
        //m.groupCount()返回某一行匹配模式中的分组数目，第0组即匹配的整个表达式。有如下表达式：A（B（C））D
        //组0是ABCD，组1是BC，组2是C
    }

}
