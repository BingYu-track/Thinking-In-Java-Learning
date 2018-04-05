package com.dw.thinkinginjava;

public class SwitchTest {

    public static void main(String[] args){
        int n = 0;
        switch (n){
            //default:System.out.println("ERROR");
            case 5:System.out.println("A");
            case 4:System.out.println("B");break;
            //default:System.out.println("ERROR");
            case 3:System.out.println("C");break;
            case 2:System.out.println("D");break;
            case 1:System.out.println("E");break;
            default:System.out.println("ERROR");
        }
    }
    //依次次执行得到结果,说明首先多路寻找匹配switch选择因子的语句，一旦匹配就执行当前匹配的语句，
    // 如果其后面没有break,就继续往下执行，不会再进行选择因子的判断，直到遇到break,程序结束。
    /*
    ERROR
    A
    B
    ----------------
    ERROR
    C
    ----------------
    ERROR
    */
}
