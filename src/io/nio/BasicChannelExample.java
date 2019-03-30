package io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @version 1.0
 * @Description: Channel基本操作示例
 * @author: hxw
 * @date: 2019/3/31 0:08
 */
public class BasicChannelExample {

    public static void main(String[] args){
        try (RandomAccessFile aFile = new RandomAccessFile("BasicChannelExample.java", "rw")) {
            FileChannel inChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(48);
            int bytesRead = inChannel.read(buf); //将BasicChannelExample.java文件数据输入到buf，注意这里返回的是已读取的字节数如果为-1说明到了末尾
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }

                buf.clear(); //这里清空
                bytesRead = inChannel.read(buf); //再次从通道获取数据
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
