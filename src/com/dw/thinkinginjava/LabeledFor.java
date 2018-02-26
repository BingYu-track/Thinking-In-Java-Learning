package com.dw.thinkinginjava;

public class LabeledFor {

	/*public static void main(String[] args) {
			int i = 0;
			outer: // Can't have statements here
			for(; true ;) { // infinite loop
				inner: // Can't have statements here
				for(; i < 10; i++) {
					System.out.println("i = " + i);
					
				if(i == 2) {
					System.out.println("continue");
					continue;
				}
				
				if(i == 3) {
					System.out.println("break");
					i++; // Otherwise i never
					// gets incremented.
					break;   //中断程序执行并跳出最内层循环
				}
				
				if(i == 7) {
					System.out.println("continue outer");
					i++; // Otherwise i never
					// gets incremented.
					continue outer;
				}
				
				if(i == 8) {
					System.out.println("break outer");
					break outer; //跳出outer标签后的循环
				}
				
				for(int k = 0; k < 5; k++) {
					if(k == 3) {
						System.out.println("continue inner");
						continue inner; //直接跳到inner标签后的循环
					}
				}
				
			}
		}
	}*/
	
	public static void main(String[] args) {
		int k = 0;
		outer:
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				k++;
				System.out.println(k);
				if(k==50){
					break outer; //直接跳出最外层循环
				}
			}
		}
	}

}
