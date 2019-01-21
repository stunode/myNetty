package com.ryan.mynetty.handler.serverHandler;

import com.ryan.mynetty.pojo.Packet;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 类名称: PacketServerHandler
 * 功能描述:
 * 日期:  2019/1/21 15:14
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class PacketServerHandler extends SimpleChannelInboundHandler<Packet> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Packet packet) throws Exception {

        System.out.println("accept packet");
        System.out.println(packet.getUsername());
        System.out.println(packet.getPassword());

    }
}
