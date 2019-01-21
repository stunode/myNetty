package com.ryan.mynetty.protocol;

import com.ryan.mynetty.pojo.Packet;
import com.ryan.mynetty.serializer.JSONSerializer;
import com.ryan.mynetty.serializer.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/**
 * 类名称: PacketCodec
 * 功能描述:
 * 日期:  2019/1/21 14:06
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class PacketCodec {

    public static final Serializer serializer = new JSONSerializer();

    public Packet decode(ByteBuf byteBuf) {

        // 数据包长度
        int length = byteBuf.readInt();
        byte[] bytes = new byte[length];
        // 读取数据
        byteBuf.readBytes(bytes);
        // 反序列化
        return serializer.deserialize(Packet.class,bytes);
    }

    public ByteBuf encode(Packet packet){

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
        byte[] bytes = serializer.serialize(packet);
        // 写入数据包长度
        byteBuf.writeInt(bytes.length);
        // 写入数据
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }
}
