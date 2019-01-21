package com.ryan.mynetty.pojo;

import lombok.Data;

import java.io.Serializable;
import java.net.ServerSocket;

/**
 * 类名称: Packet
 * 功能描述:
 * 日期:  2019/1/21 13:57
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
@Data
public class Packet implements Serializable {


    private static final long serialVersionUID = 105745461068179393L;

    public String username;

    public String password;

    public Packet(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
