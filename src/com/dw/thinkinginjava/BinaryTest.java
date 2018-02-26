package com.dw.thinkinginjava;

public class BinaryTest {
	
	public static void main(String[] args) {
		toBinaryString(32);
	}

	/**
	 * 十进制转二进制
	 * @param i
	 */
	private static void toBinaryString(int i) {
		char[] buffer = new char[32]; //创建一个32位的char数组
		int bufferPosition = 32;
		for(int k=0;k<32;k++){
			buffer[k] = 0;
		}
		do {
			buffer[--bufferPosition] = ((i & 0x01) != 0) ? '1' : '0'; //和1进行一次与运算，并把结果作为位数存放到char数组里(从低位到高位)
			i >>>= 1; //i无符号向右移动一位
		} while (i != 0);
		System.out.println(buffer);
	}
}
