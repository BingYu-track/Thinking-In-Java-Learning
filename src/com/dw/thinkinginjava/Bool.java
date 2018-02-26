package com.dw.thinkinginjava;

import java.util.Random;

/**
 * 位运算总结
 */
public class Bool {
	
	public static void main(String[] args) {
		//左移位操作符：<< 能按照操作符右侧指定的位数将操作符左边的操作数向左移动(在低位补0)
		int i = 5;
		System.out.println("i的二进制："+Integer.toBinaryString(i));//i的二进制：101
		System.out.println("i左移1位后的二进制："+Integer.toBinaryString(i << 1));//i左移1位后的二进制：1010
		System.out.println("i左移2位后的二进制："+Integer.toBinaryString(i << 2));//i左移2位后的二进制：10100
		System.out.println("-----------------------------------");
		
		//有符号右移位操作符：>> 按照操作符右侧指定的位数将操作符左边的操作数向右移动；若操作数符号为正，则在高位插入0；若符号为负，则在高位插入1.
		int j = 10;
		System.out.println("j的二进制："+Integer.toBinaryString(j));//j的二进制：1010
		System.out.println("j有符号右移1位后的二进制："+Integer.toBinaryString(j >> 1));//j有符号右移1位后的二进制：101
		System.out.println("j有符号右移2位后的二进制："+Integer.toBinaryString(j >> 2));//j有符号右移2位后的二进制：10
		System.out.println("-----------------------------------");
		
		j = -10;//注意：在计算机中，负数以其整数的补码形式存在。补码=原码取反，再加1
		System.out.println("j的二进制："+Integer.toBinaryString(j));//j的二进制：11111111111111111111111111110110
		System.out.println("j有符号右移1位后的二进制："+Integer.toBinaryString(j >> 1));//j有符号右移1位后的二进制：11111111111111111111111111111011
		System.out.println("j有符号右移2位后的二进制："+Integer.toBinaryString(j >> 2));//j有符号右移2位后的二进制：11111111111111111111111111111101
		System.out.println("-=-------------------------------------");
		
		//无符号右移位操作符：>>> 无论操作数是正是负，都在高位插入0.
		int k = 10;
		System.out.println("k的二进制："+Integer.toBinaryString(k));//k的二进制：1010
		System.out.println("k无符号右移1位后的二进制："+Integer.toBinaryString(k >>> 1));//k无符号右移1位后的二进制：101
		System.out.println("k无符号右移2位后的二进制："+Integer.toBinaryString(k >>> 2));//k无符号右移2位后的二进制：10
		System.out.println("-=-------------------------------------");
		
		k = -10;
		System.out.println("k的二进制："+Integer.toBinaryString(k));//k的二进制：11111111111111111111111111110110
		System.out.println("k无符号右移1位后的二进制："+Integer.toBinaryString(k >>> 1));//k无符号右移1位后的二进制：01111111111111111111111111111011
		System.out.println("k无符号右移2位后的二进制："+Integer.toBinaryString(k >>> 2));//k无符号右移2位后的二进制：00111111111111111111111111111101
	}

}
