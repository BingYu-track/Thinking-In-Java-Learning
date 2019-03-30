package io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/3/30 15:03
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要发送的信息：");
        while (scanner.hasNextLine()){
            //将输入的信息发送到服务器
            String msg = scanner.nextLine();
            outputStream.write(msg.getBytes());

            //读取打印服务端发送的信息
            byte[] b = new byte[1024];
            int len = inputStream.read(b);
            if(len==-1){
                break;
            }
            System.out.println("收到服务端信息："+new String(b,0,len));

            System.out.println("请输入要发送的信息：");
        }
    }
}
