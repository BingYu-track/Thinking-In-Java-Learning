package strings;

import net.mindview.util.TextFile;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/8/25 23:48
 */
public class JGrep {


    public void test(String[] args) throws Exception {
        if(args.length < 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[1]);
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");
        for(String line : new TextFile(args[0])) {
            m.reset(line);
            while(m.find()){
                System.out.println(index++ + ": " + m.group() + ": " + m.start());
            }
        }
    }

    @Test
    public void test1() throws Exception {
        String[] args = new String[]{"D:\\Eclipse_Code\\ThinkInJava\\src\\strings\\JGrep.java", "\\b[Ssct]\\w+"};
        test(args);
    }
}
