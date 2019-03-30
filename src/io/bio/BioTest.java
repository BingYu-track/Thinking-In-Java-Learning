package io.bio;

import java.io.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/3/30 16:18
 */
public class BioTest {

    public static void main(String[] args) throws IOException {
        String path = "";
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] b = new byte[8192 * 2];
        int size = 0;
        int count = 0;
        while ((size=fileInputStream.read(b))>=0){
            count +=size;
        }
        System.out.println(count);
    }
}
