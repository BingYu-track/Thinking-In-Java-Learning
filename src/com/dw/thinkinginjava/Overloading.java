package com.dw.thinkinginjava;

//重载测试
public class Overloading {
	
	static void prt(String s) {
		System.out.println(s);
	}
	
	public Overloading() {
		System.out.println("初始化");
	}
	
	void f1(char x) { prt("f1(char)"); }
	void f1(byte x) { prt("f1(byte)"); }
	void f1(short x) { prt("f1(short)"); }
	void f1(int x) { prt("f1(int)"); }
	void f1(long x) { prt("f1(long)"); }
	void f1(float x) { prt("f1(float)"); }
	void f1(double x) { prt("f1(double)"); }
	
	void f2(byte x) { prt("f2(byte)"); }
	void f2(short x) { prt("f2(short)"); }
	void f2(int x) { prt("f2(int)"); }
	void f2(long x) { prt("f2(long)"); }
	void f2(float x) { prt("f2(float)"); }
	void f2(double x) { prt("f2(double)"); }
	
	void f3(short x) { prt("f3(short)"); }
	void f3(int x) { prt("f3(int)"); }
	void f3(long x) { prt("f3(long)"); }
	void f3(float x) { prt("f3(float)"); }
	void f3(double x) { prt("f3(double)"); }
	
	void f4(int x) { prt("f4(int)"); }
	void f4(long x) { prt("f4(long)"); }
	void f4(float x) { prt("f4(float)"); }
	void f4(double x) { prt("f4(double)"); }
	
	void f5(long x) { prt("f5(long)"); }
	void f5(float x) { prt("f5(float)"); }
	void f5(double x) { prt("f5(double)"); }
	
	void f6(float x) { prt("f6(float)"); }
	void f6(double x) { prt("f6(double)"); }
	
	void f7(double x) { prt("f7(double)"); }
	
	void testConstVal() {
		prt("Testing with 5");
		f1(5);f2(5);f3(5);f4(5);f5(5);f6(5);f7(5);
	}
	
	void testChar() {
		char x = 'x';
		prt("char argument:");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	
	void testByte() {
		byte x = 0;
		prt("byte argument:");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	
	void testShort() {
		short x = 0;
		prt("short argument:");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	
	void testInt() {
		int x = 0;
		prt("int argument:");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	
	void testFloat() {
		float x = 0;
		prt("float argument:");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	
	void testLong() {
		long x = 0;
		prt("long argument:");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	
	void testDouble() {
		double x = 0;
		prt("double argument:");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	
	public static void main(String[] args) {
		Overloading p = new Overloading();
		p.testConstVal();
		System.out.println("--------------------------");
		p.testChar();
		System.out.println("--------------------------");
		p.testByte();
		System.out.println("--------------------------");
		p.testShort();
		System.out.println("--------------------------");
		p.testInt();
		System.out.println("--------------------------");
		p.testLong();
		System.out.println("--------------------------");
		p.testFloat();
		System.out.println("--------------------------");
		p.testDouble(); 
	}

}
