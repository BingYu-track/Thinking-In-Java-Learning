package com.dw.thinkinginjava.initilization.垃圾回收机制;

import com.dw.thinkinginjava.initilization.垃圾回收机制.Book;

/**
 * p89页
 */
public class TerminationCondition {

    public static void main(String[] args){
        Book novel = new Book(true);
        novel.checkIn();
        new Book(true);
        System.gc(); //打印出   Error: checked out 说明新创建的book对象调用了它自己的finalize方法
    }
}
