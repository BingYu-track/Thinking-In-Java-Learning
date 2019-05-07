package io;

import java.nio.*;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @version 1.0
 * @Description: 各个基本数据类型在byteBuffer里的存储形式
 * @author: bingyu
 * @date: 2019/5/7 21:38
 */
public class ViewBuffers{

    public static void main(String[] args){
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{ 0, 0, 0, 0, 0, 0, 0, 'a' });
        bb.rewind();
        printnb("Byte Buffer ");
        while(bb.hasRemaining()){
            printnb(bb.position()+ " -> " + bb.get() + ", ");
        }
        print();
        CharBuffer cb = ((ByteBuffer)bb.rewind()).asCharBuffer();
        printnb("Char Buffer ");
        while(cb.hasRemaining()){
            printnb(cb.position() + " -> " + cb.get() + ", ");
        }
        print();
        FloatBuffer fb = ((ByteBuffer)bb.rewind()).asFloatBuffer();
        printnb("Float Buffer ");
        while(fb.hasRemaining()){
            printnb(fb.position()+ " -> " + fb.get() + ", ");
        }
        print();
        IntBuffer ib = ((ByteBuffer)bb.rewind()).asIntBuffer();
        printnb("Int Buffer ");
        while(ib.hasRemaining()){
            printnb(ib.position()+ " -> " + ib.get() + ", ");
        }
        print();
        LongBuffer lb = ((ByteBuffer)bb.rewind()).asLongBuffer();
        printnb("Long Buffer ");
        while(lb.hasRemaining()){
            printnb(lb.position()+ " -> " + lb.get() + ", ");
        }
        print();
        ShortBuffer sb = ((ByteBuffer)bb.rewind()).asShortBuffer();
        printnb("Short Buffer ");
        while(sb.hasRemaining()){
            printnb(sb.position()+ " -> " + sb.get() + ", ");
        }
        print();
        DoubleBuffer db = ((ByteBuffer)bb.rewind()).asDoubleBuffer();
        printnb("Double Buffer ");
        while(db.hasRemaining()){
            printnb(db.position()+ " -> " + db.get() + ", ");
        }
        //产生这样的原因应该是每个基本数据类型所占字节不同，    char和short占2个字节   float和int占4个字节  double和long占8个字节
    }
}
