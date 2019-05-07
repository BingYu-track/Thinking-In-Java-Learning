package io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Arrays;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description: 字节存放顺序改变
 * @author: bingyu
 * @date: 2019/5/7 22:35
 */
public class Endians {


    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcdef");
        print(Arrays.toString(bb.array())); //返回实现此buffer缓冲区的 byte 数组，注意更改该数组会导致缓冲区内容的修改

        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN); //BIG_ENDIAN (是一种字节顺序，表示高位字节存储在最低的内存地址处)
        bb.asCharBuffer().put("abcdef");
        print(Arrays.toString(bb.array())); // [0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102] 注意，由于存储的是char，char占2个字节，因此一个字符占了数组bb的两个空间

        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN); //LITTLE_ENDIAN (也是一种字节顺序，表示高位字节存储在最高的内存地址处)
        bb.asCharBuffer().put("abcdef");
        print(Arrays.toString(bb.array())); // [97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102, 0]   很明显，每个字符里的高位的字节移动到了最低的内存地址

        System.out.println("----------------------------");
        System.out.println(Integer.toBinaryString(20)); //00000000 00010100  这是short类型20 的四个字节以BIG_ENDIAN顺序存储
        //若按照LITTLE_ENDIAN就变成 00010100 00000000 ，十进制为5120

        ByteBuffer b2 = ByteBuffer.wrap(new byte[2]);
        b2.order(ByteOrder.BIG_ENDIAN);
        b2.asShortBuffer().put((short) 20);
        print("BIG_ENDIAN :" + Arrays.toString(b2.array())); //BIG_ENDIAN :[0, 20]
        print(b2.asShortBuffer().get()); //20

        b2.rewind();
        b2.order(ByteOrder.LITTLE_ENDIAN);
        print("LITTLE_ENDIAN: "+ b2.asShortBuffer().get()); //5120

        b2.asShortBuffer().put((short) 20);
        print("LITTLE_ENDIAN: "+ Arrays.toString(b2.array())); //[20, 0]

    }
}
