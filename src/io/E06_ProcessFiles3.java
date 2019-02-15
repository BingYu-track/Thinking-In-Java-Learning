package io;

import net.mindview.util.ProcessFiles;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * @version 1.0
 * @Description: 使用ProcessFiles查找在特定日期之后修改的特定目录子树中的所有Java源代码文件。
 * @author: hxw
 * @date: 2019/2/14 18:27
 */
public class E06_ProcessFiles3 {

    public static void main(String[] args) { //args:{".","1/1/06"}
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US); //获取日期格式器，该格式器具有给定语言环境的给定格式化风格
        if(args.length != 2) {
            System.err.println("Usage: java E06_ProcessFiles3 path date");
            return;
        }
        long tmp = 0;
        try {
            df.setLenient(false); //指定日期/时间 严格解析
            tmp = df.parse(args[1]).getTime(); //DateFormat解析字符串生成日期
        } catch(ParseException pe) {
            pe.printStackTrace();
            return;
        }
        final long modTime = tmp;
        //重难点理解代码
        new ProcessFiles(new ProcessFiles.Strategy() {
            public void process(File file) {
                if(modTime < file.lastModified()){
                    System.out.println(file);
                }
            }
        }, "java").start(new String[] {args[0]});
    }
}
