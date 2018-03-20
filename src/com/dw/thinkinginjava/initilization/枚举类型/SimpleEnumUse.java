package com.dw.thinkinginjava.initilization.枚举类型;

import java.util.Arrays;

public class SimpleEnumUse {

    public static void main(String[] args){
        Spiciness howHot = Spiciness.MEDIUM;
        System.out.println(howHot);
        System.out.println(Spiciness.values().length);
        Spiciness.values();  //返回Spiciness[]
    }
}
