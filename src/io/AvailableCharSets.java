package io;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @version 1.0
 * @Description: 使用nio.charset.Charser把数据编码成多种不同类型
 * @author: hxw
 * @date: 2019/4/9 23:17
 */
public class AvailableCharSets {

    public static void main(String[] args) {
        SortedMap<String, Charset> charSets = Charset.availableCharsets(); //获取所有的编码
        Iterator<String> it = charSets.keySet().iterator();

        while(it.hasNext()) {
            String csName = it.next();
            printnb(csName);
            Iterator aliases = charSets.get(csName).aliases().iterator();
            if(aliases.hasNext()){
                printnb(": ");
            }
            while(aliases.hasNext()) {
                printnb(aliases.next());
                if(aliases.hasNext())
                    printnb(", ");
            }
            print();
        }

    }

}
