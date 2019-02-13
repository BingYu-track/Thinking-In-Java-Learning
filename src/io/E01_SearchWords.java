package io;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import net.mindview.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/13 11:04
 */
public class E01_SearchWords {

    public static void main(String[] args){ //参数规定args第一个命令行参数是文件扩展名，其余的是要搜索的单词
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            list = path.list(new FilenameFilter() {
                private String ext = args[0].toLowerCase(); //将输入的参数转化小写
                public boolean accept(File dir, String name) { //accept会在list()方法中循环被调用
                    // Only analyze source files with the specified extension (given as the first command line argument)
                    //只分析具有指定扩展名的源文件(作为第一个命令行参数)
                    if(name.toLowerCase().endsWith(ext)) { //判断name的后缀是否为ext,是就获取该文件里面的内容
                        // Only filter upon file extension?
                        if(args.length == 1){ //如果只有一个元素即扩展名，直接返回
                            return true;
                        }
                        Set<String> words = new HashSet<String>(
                                new TextFile(new File(dir, name).getAbsolutePath(), "\\W+") // \W 非单词字符
                        ); //获取文件里所有单词的Set集合
                        for(int i = 1; i < args.length; i++){ //判断要搜索的单次是否存在当前文件中
                            if(words.contains(args[i]))
                                return true;
                        }
                    }
                    return false;
                }
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);

    }
}
