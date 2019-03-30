package io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/3/31 1:17
 */
public class BasicBufferUsage {

    public static void main(String[] args){
        try (RandomAccessFile aFile = new RandomAccessFile("BasicBufferUsage.java", "rw")) {
            FileChannel inChannel = aFile.getChannel();
            //create buffer with capacity of 48 bytes
            ByteBuffer buf = ByteBuffer.allocate(48);
            int bytesRead = inChannel.read(buf); //read into buffer.
            while (bytesRead != -1) {
                buf.flip();  //make buffer ready for read
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get()); // read 1 byte at a time
                }
                buf.clear(); //make buffer ready for writing
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
