package io;

import org.junit.Test;

import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @version 1.0
 * @Description: flush()方法测试
 * @author: hxw
 * @date: 2019/2/20 13:30
 */
public class TestFlush {

    /**
     提前须知：FileOutPutStream继承OutputStream,并不提供flush()方法的重写，所以无论内容多少write都会将二进制流直接传递给底层操作系统的I/O,
     flush无效果。而Buffered系列的输入输出流函数单从Buffered这个单词就可以看出他们是使用缓冲区的。应用程序每次IO都要和设备进行通信，
     效率很低，因此缓冲区为了提高效率，当写入设备时，先写入缓冲区，每次等到缓冲区满了时，就将数据一次性整体写入设备，
     避免了每一个数据都和IO进行一次交互，IO交互消耗太大。
     */

    @Test
    public void test1(){
        String s = "Hello World";
        try {
            // create a new stream at specified file
            PrintWriter pw = new PrintWriter(System.out);
            // write the string in the file
            pw.write(s);
            // flush the writer
           //pw.flush(); 不使用flush()，发现控制台没有输出，这是因为pw在write是实际是写入的缓冲区在缓冲区没有填满之前是不会输出的
                          //而使用flush()我们就看了控制台的输出
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void test2(){
        String s = "Hello World";
        try {
            // create a new stream at specified file
            PrintWriter pw = new PrintWriter(System.out); //注意：其实这里创建的PrintWriter之所以有缓冲，其实在该构造器中传入的字节流后已经调用了BufferReader
            // write the string in the file
            pw.write(s);
            pw.close(); //发现使用close()同样能看到结果
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 因为close的时候，会把你没flush掉的一起flush掉。缓冲区中的数据保存直到缓冲区满后才写出，也可以使用flush方法
     * 将缓冲区中的数据强制写出或使用close()方法关闭流，关闭流之前，缓冲输出流将缓冲区数据一次性写出。
     * 在上面两个例子中，flash()和close()都使数据强制写出，所以两种结果是一样的，如果都不写的话，会发现不能成功写出
     */

    /**
     * 下面两个例子证明java默认缓冲区大小为8192字节
     */
    @Test
    public void test3(){
        char[] array  = new char[8192];
        Arrays.fill(array,'s');
        PrintWriter pw = new PrintWriter(System.out);
        pw.write(array); //没有输出
    }

    @Test
    public void test4(){
        char[] array  = new char[8193];
        Arrays.fill(array,'s');
        PrintWriter pw = new PrintWriter(System.out);
        pw.write(array); //输出结果
    }


}
