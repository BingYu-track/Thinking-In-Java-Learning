package io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @version 1.0
 * @Description: 格式化内存输入
 * @author: hxw
 * @date: 2019/2/19 10:50
 */
public class FormattedMemoryInput {

    public static void main(String[] args) throws IOException {
        try {
            byte[] bytes = BufferedInputFile.read("FormattedMemoryInput.java").getBytes();
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            DataInputStream in = new DataInputStream(bais);
            while(true)
                System.out.print((char)in.readByte());
        } catch(EOFException e) {
            //你从文件中读取对象的时候，如何判断是否读取完毕。jvm会抛出EOFException，表示的是，
            //"文件中对象读取完毕"。所以在判断是否读取结束的时候，捕获掉这个异常就可以，是捕获不是抛出
            System.err.println("End of stream");
        }
    }
}
