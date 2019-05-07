package io;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2019/5/7 21:55
 */
public class E24_DoubleBufferDemo {

    private static final int BSIZE = 1024;

    public static void main(String[] args){
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer db = bb.asDoubleBuffer();
        db.put(new double[]{11, 42, 47, 99, 143, 811, 1016});
        System.out.println(db.get(3)); //99
        db.put(3, 1811);
        db.flip();
        while (db.hasRemaining()){
            double v = db.get();
            System.out.println(v);
        }
    }
}
