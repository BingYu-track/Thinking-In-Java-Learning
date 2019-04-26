package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @version 1.0
 * @Description: nio可以做到两个通道直接相连
 * @author: hxw
 * @date: 2019/3/30 13:28
 */
public class TransferTo {

    public static void main(String[] args) throws Exception { //{Args: TransferTo.java TransferTo.txt}
        if(args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out); //将通道in的文件数据直接写到out
// Or:
// out.transferFrom(in, 0, in.size());
    }
}
