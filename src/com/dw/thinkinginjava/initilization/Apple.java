package com.dw.thinkinginjava.initilization;

public class Apple {
	
	Apple getPeeled(){
		return Peeler.peel(this);
	}
}
