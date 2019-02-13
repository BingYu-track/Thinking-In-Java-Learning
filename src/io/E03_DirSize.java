package io;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description: File.length()方法获取文件的字节数
 * @author: hxw
 * @date: 2019/2/13 16:05
 */
public class E03_DirSize {

    public static void main(final String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        long total = 0;
        long fs;
        for(String dirItem : list) {
            // 使用File(File parent, String child) 根据 parent 抽象路径名和 child 路径名字符串创建了一个新 File 实例，它表示当前目录下遍历的文件
            fs = new File(path, dirItem).length(); //获取目下文件的长度
            print(dirItem + ", " + fs + " byte(s)");
            total += fs; //文件长度相加
        }
        print("=======================");
        print(list.length + " file(s), " + total + " bytes");
    }
}
