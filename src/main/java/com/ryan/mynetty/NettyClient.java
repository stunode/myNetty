package com.ryan.mynetty;


import com.ryan.mynetty.handler.clientHandler.MyClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;

/**
 * 类名称: NettyClient
 * 功能描述:
 * 日期:  2019/1/21 10:46
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class NettyClient {

    public static void main(String[] args) {

        try {
            final Bootstrap bootstrap = new Bootstrap();
            NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();

            bootstrap.group(nioEventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<NioSocketChannel>() {
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new MyClientHandler());
                        }
                    });
            bootstrap.connect("127.0.0.1", 8889);

//            // 连接并向chanenl中写数据
//            Channel channel = bootstrap.connect("127.0.0.1", 8889).channel();
//            while (true){
//                channel.writeAndFlush(new Date() + ":hello world");
//                System.out.println("client send msg : " + new Date() + ":hello world");
//                Thread.sleep(2000);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
