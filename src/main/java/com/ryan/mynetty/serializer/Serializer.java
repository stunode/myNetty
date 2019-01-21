package com.ryan.mynetty.serializer;

import java.io.ObjectInputStream;

/**
 * 类名称: Serializer
 * 功能描述:
 * 日期:  2019/1/21 14:22
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public interface Serializer {

    byte[] serialize(Object object);

    <T> T deserialize(Class<T> clazz,byte[] bytes);
}
