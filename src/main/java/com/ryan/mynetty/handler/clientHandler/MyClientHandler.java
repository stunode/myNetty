package com.ryan.mynetty.handler.clientHandler;

import com.ryan.mynetty.pojo.Packet;
import com.ryan.mynetty.protocol.PacketCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
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
@ChannelHandler.Sharable
public class MyClientHandler extends ChannelInboundHandlerAdapter {

    private final PacketCodec codec = new PacketCodec();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println(new Date() + ": 客户端写出数据");
        Packet packet = new Packet("ryan", "123123");
        ByteBuf packetEncode = codec.encode(packet);
        // 向byteBuf中写数据
        ctx.channel().writeAndFlush(packetEncode);
    }

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//
//        System.out.println(msg);
//        // 发送数据
//        ByteBuf sendBuf = ctx.alloc().buffer();
//        sendBuf.writeBytes("客户端发送数据".getBytes());
//        Channel channel = ctx.channel();
//        Thread.sleep(2000);
//        channel.writeAndFlush(sendBuf);
//    }

}
