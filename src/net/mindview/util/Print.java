package net.mindview.util;

import java.io.PrintStream;

public class Print {

    public static void print(Object object){
        System.out.println(object);
    }

    public static void print(){
        System.out.println();
    }

    public static void printnb(Object object){
        System.out.println(object);
    }
    public static PrintStream printf(String format,Object... args){
        return System.out.printf(format,args);  //使用指定格式字符串和参数将格式化的字符串写入此输出流的便捷方法
    }
}
