package io;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;

/**
 * @version 1.0
 * @Description: File 的作用就是一个文件或目录的抽象表示，事实上叫做FilePath更合理
 * @author: hxw
 * @date: 2019/2/12 11:28
 */
public class DirList {

    public static void main(String[] args) {
        File path = new File("."); //参数"."点表示当前路径(即当前项目的路径),用当前路径生成一个File实例
        System.out.println(path.getAbsolutePath() + "\n" + path.isDirectory()); // D:\Eclipse_Code\ThinkInJava\.
        String[] list;
        if(args.length == 0){
            list = path.list(); //获取抽象路径表示的目录中所有的文件和目录
        }else{
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER); //按照字母排序，忽略大小写
        for(String dirItem : list)
            System.out.println(dirItem);
    }

    /**
     注意：java程序中的路径指的是，java命令执行时所在路径。用eclipse执行java程序，相当于如下命令行执行。
     F:\Eclipse>java -classpath ./bin DirList 《Thinking in java》中应该指的是下面的执行方式。
     F:\Eclipse\bin>java -classpath . DirList或者F:\Eclipse\bin>java DirList
     两种方式，java命令执行时，所在的目录不同，结果自然不同。
     */

    //使用正则作为参数
    @Test
    public void test(){
        String[] args = {"D.*\\.java"}; // D.*\.java  匹配D盘下所有目录下的.java文件
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            list = path.list(new DirFilter(args[0])); //返回所有与正则表达式匹配的文件名或目录
            //这里使用策略模式，将DirFilter对象传递给File.list()方法，使list()方法可以回调DirFilter的accept()方法
            //这样就可以灵活的根据传过来的接口改变list()方法的行为方式
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER); //按照字母排序，忽略大小写
        for(String dirItem : list)
            System.out.println(dirItem);
    }
}
