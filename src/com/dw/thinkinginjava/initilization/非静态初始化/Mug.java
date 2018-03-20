package com.dw.thinkinginjava.initilization.非静态初始化;

public class Mug {

    Mug(int marker){
        System.out.println("Mug("+marker+")");
    }
    void f(int marker){
        System.out.println("f("+marker+")");
    }
}
