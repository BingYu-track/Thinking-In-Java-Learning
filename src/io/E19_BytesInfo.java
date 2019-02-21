package io;

import net.mindview.util.BinaryFile;

import java.io.IOException;
import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/21 19:07
 */
public class E19_BytesInfo {

    public static void main(String[] args) throws IOException {
        Map<Byte,Integer> bytesStat = new HashMap<Byte,Integer>();
        for (byte bt : BinaryFile.read("E19_BytesInfo.java")) {
            Integer freq = bytesStat.get(bt);
            bytesStat.put(bt, freq == null ? 1 : freq + 1);
        }
        List<Byte> keys = new ArrayList<Byte>(bytesStat.keySet());
        Collections.sort(keys);
        for(Byte key : keys)
            System.out.println(key + " => " + bytesStat.get(key));
    }
}
