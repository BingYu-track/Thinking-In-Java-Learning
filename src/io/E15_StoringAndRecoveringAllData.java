package io;

import java.io.*;

import static net.mindview.util.Print.print;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/20 16:36
 */
public class E15_StoringAndRecoveringAllData {

    public static void main(String[] args)throws IOException {
        DataOutputStream out = new DataOutputStream(
                                    new BufferedOutputStream(
                                        new FileOutputStream("Data.txt")));
        out.writeBoolean(true);
        out.writeByte(100);
        out.writeByte(255);
        out.writeChar('A');
        out.writeFloat(1.41413f);
        out.writeLong(1000000000L);
        out.writeInt(100000);
        out.writeShort(30000);
        out.writeShort(65535);
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.close();

        DataInputStream in = new DataInputStream(
                                new BufferedInputStream(
                                    new FileInputStream("Data.txt")));
        print(in.readBoolean());
        print(in.readByte());
        print(in.readUnsignedByte());
        print(in.readChar());
        print(in.readFloat());
        print(in.readLong());
        print(in.readInt());
        print(in.readShort());
        print(in.readUnsignedShort());
        print(in.readDouble());
        // Only readUTF() will recover the Java-UTF String properly:
        print(in.readUTF());
    }
}
