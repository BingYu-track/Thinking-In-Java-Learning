package strings.exercise;

import net.mindview.util.TextFile;
import org.junit.Test;
import static net.mindview.util.Print.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description: 匹配并打印所有注释
 * @author: hxw
 * @date: 2018/8/26 13:25
 */
public class E17_JCommentExtractor {

    static final String CMNT_EXT_REGEX =
                    "(?x)(?m)(?s) # Comments, Multiline & Dotall: ON\n" + //注意由于使用了(?x)，正则表达式忽略空格和#到其行末,
                    "/\\* # Match START OF THE COMMENT\n" +
                    "(.*?) # Match all chars\n" +
                    "\\*/ # Match END OF THE COMMENT\n" +
                    "| //(.*?)$ # OR Match C++ style comments\n";

    public static void main(String[] args) throws Exception {
        args = new String[]{"D:\\Eclipse_Code\\ThinkInJava\\src\\strings\\exercise\\E17_JCommentExtractor.java"};
        if(args.length < 1) {
            System.out.println("Usage: java E17_JCommentExtractor file");
            System.exit(0);
        }
        String src = TextFile.read(args[0]);
        Pattern p = Pattern.compile(CMNT_EXT_REGEX);
        Matcher m = p.matcher(src);
        while(m.find()){
            System.out.println(m.group(1) != null ? m.group(1) : m.group(2));
        }
    }
    /*
    输出：
    *
     * @version 1.0
     * @Description: 匹配并打印所有注释
     * @author: hxw
     * @date: 2018/8/26 13:25
    (.*?)$ # OR Match C++ style comments\n";

    */

}
