package io;

import java.io.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/20 15:42
 */
public class StoringAndRecoveringData {

    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                                    new BufferedOutputStream(
                                        new FileOutputStream("Data.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in = new DataInputStream(
                                new BufferedInputStream(
                                    new FileInputStream("Data.txt")));
        System.out.println(in.readDouble());
        // Only readUTF() will recover the Java-UTF String properly: 只有readUTF()方法才能恢复java的UTF字符
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
