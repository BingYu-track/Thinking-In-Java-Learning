package com.dw.thinkinginjava.initilization.垃圾回收机制;

public class Finalize {

    protected void finalize() {
        System.out.println("finalize() called");
    }
    public static void main(String args[]) {
        new Finalize();
    }
}
