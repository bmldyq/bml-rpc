package com.bml.common.registry.channelLizer;

import com.bml.common.registry.handler.NettyServerHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public interface NettyChannelInitLizer<T extends ChannelHandler> extends InitLizerChannel<T> {


    void addLast(ChannelPipeline pipeline);

    default ChannelInitializer<SocketChannel> initLizer() {
        return new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                addLast(pipeline);
                pipeline.addLast(getServerHandler());
            }
        };


    }
}
