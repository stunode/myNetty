package com.ryan.tradition;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 类名称: Server
 * 功能描述: socket 服务端
 * 日期:  2019/1/21 9:53
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class Server {

    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                try {
                    ServerSocket serverSocket = new ServerSocket(8888);

                    Socket socket = serverSocket.accept();
                    new Thread(()->{
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data,0,len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
