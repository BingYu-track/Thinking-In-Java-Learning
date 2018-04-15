package com.dw.thinkinginjava.initilization;

public class Flower {
	int petalCount = 0;
	String s = "initial value";
	Flower(int petals) { //petal花瓣
		petalCount = petals;
		System.out.println("Constructor w/ int arg only, petalCount= " + petalCount);
	}
	Flower(String ss) {
		System.out.println("Constructor w/ String arg only, s = " + ss);
		s = ss;
	}
	Flower(String s, int petals) {
		this(petals);
		//! this(s); //用this只能调用一次构造器并且必须位于首行
		this.s = s; // Another use of "this"
		System.out.println("String & int args");
	}
	Flower() {
		this("hi", 47);
		System.out.println("default constructor (no args)");
	}
	void printPetalCount() {
	//! this(11); // 编译器报错，没有在构造器内
		System.out.println("petalCount = " + petalCount + " s = "+ s);
	}
	public static void main(String[] args) {
		Flower x = new Flower();
		x.printPetalCount();
	}

}
