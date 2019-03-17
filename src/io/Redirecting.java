package io;

import java.io.*;

/**
 * @version 1.0
 * @Description: 标准IO重定向，Java的标准输入/输出分别通过System.in和System.out来代表，在默认的情况下分别代表键盘和显示器，
 * 当程序通过System.in来获得输入时，实际上是通过键盘获得输入。当程序通过System.out执行输出时，程序总是输出到屏幕，下面的代码将System.in重定向到文件输入，所以将不接受键盘输入
 * @author: hxw
 * @date: 2019/2/24 15:19
 */
public class Redirecting {

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out; //这是原始的System.out输出
        File file = new File("Redirecting.java");
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        PrintStream out = new PrintStream(
                            new BufferedOutputStream(
                                new FileOutputStream("test.out")));
        System.setIn(in); //System.in重定向到文件Redirecting.java输入，改变了数据的来源
        System.setOut(out); //System.out也重定向到了文件test.out输出(改变前默认输出到控制台)
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        br.mark((int) file.length()); //标记文件的开头 mark(int readAheadLimit)  readAheadLimit是指在当前位置前面多少位置
        while((s = br.readLine()) != null){
            System.out.println(s); //因此这里输出的时候，控制台就不会打印出来
        }
        out.close(); // Remember this!
        System.setOut(console); //重定向到默认控制台
        br.reset(); //重置到文件开头
        while((s = br.readLine()) != null){
            System.out.println(s); //这里输出的时候，控制台就会打印出来
        }
    }
}
