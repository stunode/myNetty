package com.ryan.mynetty.serializer;

import com.alibaba.fastjson.JSON;
/**
 * 类名称: JSONSerializer
 * 功能描述:
 * 日期:  2019/1/21 14:22
 *
 * @author: renpengfei
 * @since: JDK1.8
 */
public class JSONSerializer implements Serializer {

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes,clazz);
    }
}
