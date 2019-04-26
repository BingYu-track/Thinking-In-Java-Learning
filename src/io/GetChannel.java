package io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @version 1.0
 * @Description: NIO使用案例，重点再于Buffer的flip()方法的理解
 * @author: hxw
 * @date: 2019/3/19 20:48
 */
public class GetChannel {
    private int p = 0;
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        // Write a file:
        FileChannel fc = new FileOutputStream("data.txt").getChannel(); //FileChannel用于读、写、映射和操作文件的通道，这里是返回的FileChannel的实现类FileChannelImpl
        ByteBuffer wrap = ByteBuffer.wrap("Some text ".getBytes()); //在这里就已经把数据填充到了ByteBuffer里面了，此时 position=0 ,limit=capacity=10
        fc.write(wrap);  //把ByteBuffer缓冲区里的数据写入到通道fc，最后写入文件data.txt,此时position移动到了末尾position=limit=capacity=10
        fc.close();
        // Add to the end of the file:
        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size()); // Move to the end 移动到文件通道的末尾即移动到Some text 尾部,并写入"Some more"
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        // Read the file:
        fc = new FileInputStream("data.txt").getChannel(); //获取从data.txt读取的通道
        ByteBuffer buff = ByteBuffer.allocate(BSIZE); //分配一个新的缓冲区，注意ByteBuffer是一个抽象类，无法new对象，
        // 内部使用的HeapByteBuffer实现类，是一个数组，此时 position=0 ,limit=capacity=1024
        int read = fc.read(buff);//通过通道将data.txt文件的数据填充到缓冲区，此时position=19 ,limit=capacity=1024
        buff.flip(); //(要读取buff中的数据前必须调用flip方法) 因为下面要用Buffer的get()读取数据flip()继承自Buffer这个抽象类
        //执行flip()方法后，position=0 ,limit=19 ,capacity=1024 这样指针就回到了开头，可以开始读取数据
        while(buff.hasRemaining()){ //hasRemaining()这里是判断是否position < limit，position不再小于limit，说明中间没有剩余元素了
            System.out.print((char)buff.get()); //这里ByteBuffer每get一次，position都会移动加1
        }
    }

    @Test
    public void test(){
        GetChannel channel = new GetChannel();
        int add = channel.add();
        System.out.println(channel.p); //1
        channel.add2(add);
    }

    public int add(){
        return p++; //注意这里的问题，i++是先赋值再自增，因此这里返回的仍然是原来的值
    }

    public int add2(int i){
        return i+1;
    }
}
