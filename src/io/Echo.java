package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @version 1.0
 * @Description: 标准IO
 * @author: hxw
 * @date: 2019/2/21 19:28
 */
public class Echo {

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)); //读取控制台输入的信息
        String s;
        while((s = stdin.readLine()) != null && s.length()!= 0) //当有信息时输出
            System.out.println(s);
        // An empty line or Ctrl-Z terminates the program
    }
}
