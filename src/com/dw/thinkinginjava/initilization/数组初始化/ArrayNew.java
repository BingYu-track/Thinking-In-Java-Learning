package com.dw.thinkinginjava.initilization.数组初始化;

import com.dw.thinkinginjava.initilization.非静态初始化.Mug;
import com.dw.thinkinginjava.initilization.非静态初始化.Mugs;

import java.util.Arrays;
import java.util.Random;

public class ArrayNew {
    public static void main(String[] args){
        int[] g;
        Random rand = new Random(47);
        g = new int[rand.nextInt(20)]; //
        System.out.println("数组长度"+g.length+Arrays.toString(g));
        Integer[] a = {
                new Integer(1),
                new Integer(2),
                3,   //自动装箱
        };
        Object[] b = {
                new Integer(47),
                new Float(3.14),
                new Double(11.11)
        };
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        f(1,1.2f,3.44,"你好",new ArrayNew(),new Mugs());
    }

    public static void f(Object... args){
        for (Object arg : args) {
            System.out.println(arg);
        }
    }
}
