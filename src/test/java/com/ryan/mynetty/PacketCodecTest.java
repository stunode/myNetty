package com.ryan.mynetty;

import com.ryan.mynetty.pojo.Packet;
import com.ryan.mynetty.protocol.PacketCodec;
import com.ryan.mynetty.serializer.JSONSerializer;
import com.ryan.mynetty.serializer.Serializer;
import io.netty.buffer.ByteBuf;
import org.junit.Assert;
import org.junit.Test;

/**
 * 类名称: PacketCodecTest
 * 功能描述:
 * 日期:  2019/1/21 14:38
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class PacketCodecTest {

    @Test
    public void packetCodecTest(){

        Serializer serializer = new JSONSerializer();
        Packet packet = new Packet("ryan","123123");

        PacketCodec packetCodec = new PacketCodec();
        ByteBuf byteBuf = packetCodec.encode(packet);

        Packet decodePacket = packetCodec.decode(byteBuf);

        // 断言验证，序列化后的对象应该相同
        Assert.assertArrayEquals(serializer.serialize(packet),serializer.serialize(decodePacket));
    }

}
