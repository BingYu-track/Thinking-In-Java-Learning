package io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/19 14:36
 */
public class TestEOF {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("TestEOF.java");
        BufferedInputStream bis = new BufferedInputStream(fileInputStream);
        DataInputStream in = new DataInputStream(bis);
        while(in.available() != 0){ // available()返回剩余字节数
            System.out.print((char)in.readByte());
        }
    }
}
