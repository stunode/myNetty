package com.ryan.mynetty.handler.serverHandler;

import com.ryan.mynetty.pojo.Packet;
import com.ryan.mynetty.protocol.PacketCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * 类名称: MyServerDecoder
 * 功能描述:
 * 日期:  2019/1/21 15:11
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
@ChannelHandler.Sharable
public class MyServerDecoder extends MessageToMessageDecoder<ByteBuf> {

    private final PacketCodec packetCodec = new PacketCodec();
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Packet packet = packetCodec.decode(byteBuf);
        list.add(packet);
    }
}
