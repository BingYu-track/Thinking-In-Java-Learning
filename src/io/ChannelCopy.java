package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/3/30 12:45
 */
public class ChannelCopy {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception { //{Args: ChannelCopy.java test.txt}
        if(args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while(in.read(buffer) != -1) { //从通道数据输入到缓冲区
            buffer.flip(); // Prepare for writing
            out.write(buffer); //再将之前缓冲区里的数据输出到out通道里
            buffer.clear(); // Prepare for reading
        }
    }

}
