package com.ryan.mynetty;
import com.ryan.mynetty.handler.serverHandler.MyServerDecoder;
import com.ryan.mynetty.handler.serverHandler.MyServerHandler;
import com.ryan.mynetty.handler.serverHandler.PacketServerHandler;
import com.ryan.tradition.Server;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 类名称: NettyServer
 * 功能描述:
 * 日期:  2019/1/21 10:15
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class NettyServer {

    public static void main(String[] args) {

        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        serverBootstrap
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        // 解码
//                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new MyServerDecoder());
                        // 指定handler接收类型
                        // simpleChannelInboundHandler会首先判断接受数据的类型是否匹配，如果匹配进行处理，否则交给下个channelHandler
                        ch.pipeline().addLast(new PacketServerHandler());
                        ch.pipeline().addLast(new MyServerHandler());
                    }
                });
        serverBootstrap.bind(8889);

    }
}
