package com.dw.thinkinginjava;

//斐波那契数列
public class Fibonacci {
	
	public static void main(String[] args) {
		int n = 12;
		if(n < 0) {
			System.out.println("Cannot use negative numbers");
			return;
		}
		for(int i = 1; i <= n; i++)
		System.out.print(fibonacci(i) + ", ");
	}
	
	public static int fibonacci(int n){
		if(n<=2) return 1;
		return fibonacci(n-2) + fibonacci(n-1);
	}
}
