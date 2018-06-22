package holding;

import net.mindview.util.TextFile;

import java.util.Set;
import java.util.TreeSet;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/6/22 8:31
 */
public class UniqueWords {

    public static void main(String[] args) {
        //打开文件并且将其内容读取到Set中
        Set<String> words = new TreeSet<String>(new TextFile("D:/Eclipse_Code/ThinkInJava/src/holding/SetOperations.java", "\\W+"));
        System.out.println(words);
    }
}
