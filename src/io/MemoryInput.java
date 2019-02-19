package io;

import java.io.IOException;
import java.io.StringReader;

/**
 * @version 1.0
 * @Description: 从内存输入
 * @author: hxw
 * @date: 2019/2/19 10:32
 */
public class MemoryInput {

    public static void main(String[] args) throws IOException {
        //StringReader，数据来源为字符串，从字符串中读取数据
        StringReader in = new StringReader(BufferedInputFile.read("MemoryInput.java"));
        int c;
        while((c = in.read()) != -1){ //read()是以int形式返回下一个字节，因此类型转化为char才能使用
            System.out.print((char)c);
        }
    }
    /**
     首先BufferedInputFile读取MemoryInput.java文件里的数据并将这些数据输入到内存中以字符串的形式
     */
}
