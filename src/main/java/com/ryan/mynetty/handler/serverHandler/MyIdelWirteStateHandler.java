package com.ryan.mynetty.handler.serverHandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * 类名称: MyIdelStateHandler
 * 功能描述:
 * 日期:  2019/1/21 16:36
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class MyIdelStateHandler extends IdleStateHandler {

    private static final int READER_IDLE_TIME = 10;
    private static final int WRITE_IDLE_TIME = 2;
    public MyIdelStateHandler() {
        super(READER_IDLE_TIME, WRITE_IDLE_TIME, 0, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) {
        System.out.println(READER_IDLE_TIME + "秒内未读到数据，关闭连接");
        // 关闭连接
        ctx.channel().close();
    }
}
