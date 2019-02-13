package io;

import net.mindview.util.Directory;
import net.mindview.util.PPrint;

import java.io.File;
import java.util.List;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/13 21:30
 */
public class DirectoryDemo {

    public static void main(String[] args) {
        // All directories:
        List<File> dirs = Directory.walk(".").dirs;
        PPrint.pprint(dirs); //Directory.walk(".")全是文件
        // All files beginning with ‘T’
        File[] local = Directory.local(".", "T.*"); //返回当前目录中所有以T开头的文件
        for(File file : local){
            print(file);
        }
        print("----------------------");
        // All Java files beginning with ‘T’: 返回当前目录以及其所有子目录中的所有以T开头的.java文件
        for(File file : Directory.walk(".", "T.*\\.java")){
            print(file);
        }
        print("======================");
        // Class files containing "Z" or "z": 返回当前目录以及其所有子目录中的所有包含大小字母z的.class文件
        for(File file : Directory.walk(".",".*[Zz].*\\.class")){
            print(file);
        }
    }
}
