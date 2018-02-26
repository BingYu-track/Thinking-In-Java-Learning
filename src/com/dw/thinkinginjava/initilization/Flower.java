package com.dw.thinkinginjava.initilization;

public class Flower {
	
	int petalCount = 0;
	String s = "initial value";
	
	public Flower(int petals) {
		petalCount = petals;
		System.out.println("带int的有参构造，参数petalCount ="+petalCount);
	}
	
	public Flower(String ss){
		System.out.println("带String的有参构造,s="+ss);
		s = ss;
	}

	public Flower(String s,int petals) {
		this(petals);
	}

	void print(){
		
	}
}
