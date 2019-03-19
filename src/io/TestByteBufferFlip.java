package io;

import java.nio.ByteBuffer;

/**
 * @version 1.0
 * @Description: Buffer的flip()原理测试
 * @author: hxw
 * @date: 2019/3/19 23:48
 */
public class TestByteBufferFlip {

    public static void main(String[] args){
        ByteBuffer buff = ByteBuffer.allocate(1024); //这里ByteBuffer的实现类是HeapByteBuffer
        buff.put((byte) 1);
        //用这两行代码调试来揭示Buffer读写和ByteBuffer.flip()的原理，涉及到Buffer的position,limit,capacity三个重要属性

    }
}
