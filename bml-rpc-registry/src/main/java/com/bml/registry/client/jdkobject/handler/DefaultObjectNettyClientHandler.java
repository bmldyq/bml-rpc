package com.bml.registry.client.jdkobject.handler;

import com.bml.common.registry.handler.NettyClientHandler;
import io.netty.channel.ChannelHandlerContext;

public class DefaultObjectNettyClientHandler extends NettyClientHandler {
    private Object msg;

    public Object getMsg() {
        return msg;
    }

    @Override
    public void setResponse(Object msg) {
        this.msg = msg;
    }


    @Override
    public void doChannelActive(ChannelHandlerContext ctx) {

    }

    @Override
    public void doChannelClose(ChannelHandlerContext ctx) {

    }

    @Override
    public Object doReadFromClient(ChannelHandlerContext ctx, Object msg) {
        return msg;
    }
}
