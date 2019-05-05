package io;

import java.nio.ByteBuffer;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @version 1.0
 * @Description: ByteBuffer可以存储各种不同的基本类型数据
 * @author: bingyu
 * @date: 2019/5/5 23:25
 */
public class GetData {

    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        // Allocation automatically zeroes the ByteBuffer:
        int i = 0;
        while(i++ < bb.limit()){ //这里说明当buffer为空时，里面存的都是0
            if(bb.get() != 0)
                print("nonzero");
        }
        print("i = " + i);
        bb.rewind();
        // Store and read a char array:
        bb.asCharBuffer().put("Howdy!");
        char c;
        while((c = bb.getChar()) != 0){
            printnb(c + " ");
        }
        print();
        bb.rewind();
        // Store and read a short:存储short类型
        bb.asShortBuffer().put((short)471142); //(short)471142转short类型值变为了12390
        print(bb.getShort());
        bb.rewind();
        // Store and read an int:
        bb.asIntBuffer().put(99471142);
        print(bb.getInt());
        bb.rewind();
        // Store and read a long:
        bb.asLongBuffer().put(99471142);
        print(bb.getLong());
        bb.rewind();
        // Store and read a float:
        bb.asFloatBuffer().put(99471142);
        print(bb.getFloat());
        bb.rewind();
        // Store and read a double:
        bb.asDoubleBuffer().put(99471142);
        print(bb.getDouble());
        bb.rewind();
    }
}
