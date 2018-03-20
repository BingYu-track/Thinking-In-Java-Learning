package com.dw.thinkinginjava.initilization.静态初始化;

public class StaticInitialization {

    public static void main(String[] args){
        System.out.println("在main方法中创建橱柜");
        new Cupboard();
        System.out.println("在main方法中创建橱柜");
        new Cupboard();
        System.out.println("------");
        table.f2(1);
        cupboard.f3(1);
        /*
            Bowl(1)
            Bowl(2)
            Table()
            f1(1)
            --------
            Bowl(4)
            Bowl(5)
            Bowl(3)
            Cupboard()
            f1(4)
            --------
            在main方法中创建橱柜
            Bowl(3)
            Cupboard()
            f1(4)
            在main方法中创建橱柜
            Bowl(3)
            Cupboard()
            f1(4)
            --------
            f2(1)
            f3(1)
         */
    }
    //注意静态的成员变量在类加载时就被初始化了，且只初始化一次
    static Table table = new Table(); // 1
    static Cupboard cupboard = new Cupboard();//2
}
