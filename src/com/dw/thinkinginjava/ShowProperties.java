package com.dw.thinkinginjava;

import java.util.Random;

/**
 * Description: The First Thinking in Java <br> 
 * Author: hxw <br>
 * Date: 2018年2月22日
 */
public class ShowProperties {
	
	/**
	 * main方法是程序执行的入口<br>
	 * main 方法详细说明<br>
	 * @param args true
	 * @return 没有返回值
	 */
	public static void main(String[] args) {
		/*System.getProperties().list(System.out);
		System.out.println("---------分隔线---------");
        System.out.println(System.getProperty("user.name"));
        System.out.println("---------分隔线---------");
        System.out.println(System.getProperty("java.library.path"));*/
		int i,j,k;
		Random random = new Random(47);
		i = random.nextInt(100);//返回一个伪随机、均匀分布的值。在0(包括在内)和指定的值(这里是100)之间，
		j = random.nextInt(100);
		System.out.println(i);
		System.out.println(j);
		
		System.out.println(random.nextInt(26)+'a');
	}

}
