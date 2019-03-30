package io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @Description: 理解BIO(同步阻塞IO)
 * @author: hxw
 * @date: 2019/3/30 14:44
 */
public class Server {

    public static void main(String[] args) throws IOException {
        //开启服务端，监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器已启动，等待连接--------");
        while (true){
            //阻塞式等待客户端连接，若没有连接客户端，不会继续向下执行
            Socket socket = serverSocket.accept();
            System.out.println("客户端成功连接服务器");
            //给客户端发送连接成功的信息
            OutputStream outputStream = socket.getOutputStream();
            //获取客户端发送过来的信息
            InputStream inputStream = socket.getInputStream();
            String msg = "";
            while (true){
                byte[] b = new byte[1024];
                //在这里会发现，当客户端没有发送数据的时候，程序不会向下执行，处于阻塞状态
                int len = inputStream.read(b); //等待客户端写入数据，这里体现了BIO的同步阻塞
                if(len==-1){
                    continue;
                }
                msg = new String(b,0,len);
                System.out.println("收到客户端发送的数据："+msg);
                //通知客户端已收到数据
                outputStream.write(("服务器已收到数据").getBytes());
            }
        }
    }
}
