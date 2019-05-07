package io;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @version 1.0
 * @Description: 从buffer里读取原始数据
 * @author: bingyu
 * @date: 2019/5/7 21:16
 */
public class IntBufferDemo {

    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        // Store an array of int:
        ib.put(new int[]{ 11, 42, 47, 99, 143, 811, 1016 });
        // Absolute location read and write: (读是get 写是put) 不带索引参数的方法，称为相对存取，相对存取会自动影响缓冲区的位置属性。带索引参数的方法，称为绝对存取
        System.out.println(ib.get(3)); //绝对 get 方法  ，实际是调用的底层的byteBuffer
        ib.put(3, 1811); //绝对put方法 将1811写入下标3这个位置，即替换了99
        // Setting a new limit before rewinding the buffer.
        ib.flip();
        while(ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }
    }
}
