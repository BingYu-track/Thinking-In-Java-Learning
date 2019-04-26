package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @version 1.0
 * @Description: CharBuffer的toString()方法返回包含此缓冲区中字符的字符串
 * @author: hxw
 * @date: 2019/4/9 23:03
 */
public class BufferToText {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        // Doesn’t work:
        System.out.println(buff.asCharBuffer()); //直接使用CharBuffer的toString()输出乱码
        // Decode using this system’s default Charset:
        buff.rewind(); //这里position=0 ,limit=capacity，回到开头位置，重新读取
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": " + Charset.forName(encoding).decode(buff));
        // Or, we could encode with something that will print:
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE"))); //使用了指定的字符集
        fc.close();
        // Now try reading again:
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer()); //现在可以正常的输出字符串
        // Use a CharBuffer to write through:
        fc = new FileOutputStream("data2.txt").getChannel(); //发现每次获取输出通道Channel，文件内容都会被清空
        buff = ByteBuffer.allocate(24); // More than needed
        buff.asCharBuffer().put("Some text"); //直接将数据放入CharBuffer就不会避免上面输出乱码的问题
        fc.write(buff);
        fc.close();
        // Read and display:
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }

}
