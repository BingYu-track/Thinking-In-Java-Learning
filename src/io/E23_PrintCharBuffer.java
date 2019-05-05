package io;

import javax.xml.stream.events.Characters;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.BitSet;

/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2019/5/5 22:54
 */
public class E23_PrintCharBuffer {

    static BitSet isPrintable = new BitSet(127);
    static String encoding = System.getProperty("file.encoding");
    static {
// Assume an encoding that obeys ASCII eg.ISO-8859-1.Characters 32 to 127 represent printable characters. 假设编码符合ASCII，如ISO-8859-1。字符32至127表示可打印字符
        for(int i = 32; i <= 127; i++)
            isPrintable.set(i);
    }
    // Set the position to the last printable character 设置最后一个可打印的字符位置
    public static void setPrintableLimit(CharBuffer cb) {
        cb.rewind();
        while(isPrintable.get(cb.get())); //判断cb中的字符是否处于BitSet中，一旦不满足，此时buffer的指针就是可打印的最后一位
        cb.limit(cb.position() - 1); //设置位置
        cb.rewind();
    }

    public static void main(String[] args) {
        System.out.println("Default Encoding is: " + encoding); //在使用静态变量时加载了类E23_PrintCharBuffer并执行了静态语句块
        CharBuffer buffer = ByteBuffer.allocate(16).asCharBuffer();
        buffer.put("ABCDE" + (char) 0x01 + "FG");
        buffer.rewind();
        System.out.println(buffer); // Print everything
        setPrintableLimit(buffer);
        System.out.println(buffer); // Print printable //只打印可打印的字符
    }
}
