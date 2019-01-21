package com.ryan.mynetty.handler.serverHandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 类名称: MyServerHandler
 * 功能描述:
 * 日期:  2019/1/21 13:09
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {

        //读取
        System.out.println(s);
        // 发送
        Channel ch = channelHandlerContext.channel();
        ByteBuf buf = channelHandlerContext.alloc().buffer();
        buf.writeBytes("服务端发送数据".getBytes());
        ch.writeAndFlush(buf);
    }
}
