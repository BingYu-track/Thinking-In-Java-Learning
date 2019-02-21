package io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @version 1.0
 * @Description: RandomAccessFile相当于DataOutPutStream和DataInputStream
 * @author: hxw
 * @date: 2019/2/20 17:17
 */
public class UsingRandomAccessFile {

    static String file = "rtest.dat";
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for(int i = 0; i < 7; i++){
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw"); //允许读取和写入
        for(int i = 0; i < 7; i++){
            rf.writeDouble(i*1.414);
            //rf.writeUTF(i*1.414+"");
            System.out.println(i*1.414);
        }
        rf.writeUTF("The end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "rw");
        rf.seek(5*8); //注意这里5*8指的是字节数，一个double是8个字节；直接将文件指针移到第5个double数据后面 即5.656后面，
        rf.writeDouble(47.0001); //覆盖第6个double数据,即把7.069999999999999替换成了47.0001
        rf.close();
        display();
    }

    /**
     "r" 以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。
     "rw" 打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件。
     "rws" 打开以便读取和写入，对于 "rw"，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备。
     "rwd"   打开以便读取和写入，对于 "rw"，还要求对文件内容的每个更新都同步写入到底层存储设备。
     */
}
