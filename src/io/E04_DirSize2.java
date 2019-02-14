package io;

import net.mindview.util.Directory;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description: 使用Directory.walk()计算目录中所有名字与正则匹配的文件尺寸总和
 * @author: hxw
 * @date: 2019/2/14 10:47
 */
public class E04_DirSize2 {

    public static void main(String[] args){
        List<File> files;
        if(args.length==0){
            //获取当前目录下所有匹配正则的文件(包括子目录)
            files = Directory.walk("../access").files; //这里../表示上级目录
        }else {
            files = Directory.walk("../access",args[0]).files;
        }
        long total = 0;
        long fs;
        for(File file : files) {
            long length = file.length();//获取文件的长度
            print(file.getName() + ", " + length + " byte(s)");
            total += length; //文件长度相加
        }
        print("=======================");
        print(files.size() + " file(s), " + total + " bytes");
    }
}
