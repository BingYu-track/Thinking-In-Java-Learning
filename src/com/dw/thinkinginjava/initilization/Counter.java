package com.dw.thinkinginjava.initilization;

public class Counter {

    int i;

    Counter(){
        i=7;
    }

    public static void main(String[] args){
        Counter counter = new Counter();
        System.out.println(counter.i);
    }
}
