package io;

import java.util.List;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/24 17:51
 */
public class E22_OSExecuteDemo {

    public static void main(String[] args) {
        List<String> result = OSExecute2.command("javac E22_OSExecuteDemo.java");
        for(String s : result)
            System.out.println(s);
    }
}
