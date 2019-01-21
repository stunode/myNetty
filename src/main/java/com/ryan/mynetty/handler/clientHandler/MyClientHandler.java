package com.ryan.mynetty.handler.clientHandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * 类名称: MyClientHandler
 * 功能描述:
 * 日期:  2019/1/21 11:03
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println(new Date() + ": 客户端写出数据");
        // 通过内存管理器获取一个byteBuf
        ByteBuf buffer = ctx.alloc().buffer();
        // 向byteBuf中写数据
        byte[] dataBytes = "my client handler !".getBytes(Charset.forName("utf-8"));
        buffer.writeBytes(dataBytes);
        ctx.channel().writeAndFlush(buffer);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println(msg);
        // 发送数据
        ByteBuf sendBuf = ctx.alloc().buffer();
        sendBuf.writeBytes("客户端发送数据".getBytes());
        Channel channel = ctx.channel();
        Thread.sleep(2000);
        channel.writeAndFlush(sendBuf);
    }

}
