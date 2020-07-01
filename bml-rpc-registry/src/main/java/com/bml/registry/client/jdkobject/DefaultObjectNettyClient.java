package com.bml.registry.client.jdkobject;

import com.bml.common.registry.channelLizer.NettyChannelInitLizer;
import com.bml.common.registry.handler.NettyClientHandler;
import com.bml.registry.client.AbstractClient;
import com.bml.registry.client.jdkobject.handler.DefaultObjectNettyClientHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class DefaultObjectNettyClient extends AbstractClient implements NettyChannelInitLizer<NettyClientHandler> {


    private String ip;
    private int port;

    private Object response;

    private DefaultObjectNettyClientHandler handler;

    public DefaultObjectNettyClient(String ip,int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    protected ChannelInitializer<SocketChannel> getChannelInitlizerInstance() {
        return initLizer();
    }

    @Override
    protected String getIp() {
        return ip;
    }

    @Override
    protected int getProt() {
        return port;
    }

    @Override
    protected Object getResponse() {
        return handler.getMsg();
    }

    @Override
    public NettyClientHandler getServerHandler() {
        handler = new DefaultObjectNettyClientHandler();
        return handler;
    }



    @Override
    public void addLast(ChannelPipeline pipeline) {
        pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
        pipeline.addLast(new ObjectEncoder());
    }
}
