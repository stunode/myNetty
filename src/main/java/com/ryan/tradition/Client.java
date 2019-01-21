package com.ryan.tradition;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * 类名称: Client
 * 功能描述: socket客户端
 * 日期:  2019/1/21 9:59
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class Client {

    public static void main(String[] args) {

        // 绑定ip 端口号
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8888);
                while (true) {
                    socket.getOutputStream().write((new Date() + ":hello world").getBytes());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
