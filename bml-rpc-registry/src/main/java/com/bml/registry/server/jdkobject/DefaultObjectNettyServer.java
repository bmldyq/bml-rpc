package com.bml.registry.server.jdkobject;

import com.bml.common.registry.channelLizer.NettyChannelInitLizer;
import com.bml.common.registry.handler.NettyServerHandler;
import com.bml.registry.server.AbstractServer;
import com.bml.registry.server.jdkobject.handler.DefaultObjectNettyServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class DefaultObjectNettyServer extends AbstractServer implements NettyChannelInitLizer<NettyServerHandler> {

    private int port;

    public DefaultObjectNettyServer(int port) {
        this.port = port;
    }


    @Override
    protected int getServerPort() {
        return port;
    }

    @Override
    protected ChannelInitializer<SocketChannel> getChannelInitlizerInstance() {
        return initLizer();
    }

    @Override
    public NettyServerHandler getServerHandler() {
        return new DefaultObjectNettyServerHandler();
    }

    @Override
    public void addLast(ChannelPipeline pipeline) {
        pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
        pipeline.addLast(new ObjectEncoder());
    }
}
