package com.ryan.yourenclient;

import com.ryan.yourenclient.entity.DeviceConnectionHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 类名称: YourenChannel
 * 功能描述:
 * 日期:  2019/4/1 10:34
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class YourenClients {

    public YourenClients INSTANCE = new YourenClients();

    private final ConcurrentMap<String , DeviceConnectionHolder<Byte,Client>> clientMap = new ConcurrentHashMap();

    private YourenClients() {
    }

    public void addClient(String key, DeviceConnectionHolder<Byte,Client> holder) {
        clientMap.putIfAbsent(key, holder);
    }

    public DeviceConnectionHolder<Byte,Client> getClient(String key) {
        return clientMap.get(key);
    }
}
