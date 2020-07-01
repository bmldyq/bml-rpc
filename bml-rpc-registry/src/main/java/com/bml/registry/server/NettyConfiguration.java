package com.bml.registry.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyConfiguration {

    protected  void setNettyServerOption(ServerBootstrap bootstrap){
        bootstrap.channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024)
                .option(ChannelOption.SO_SNDBUF, 32 * 1024)
                .option(ChannelOption.SO_RCVBUF,32 * 1024 )
                .option(ChannelOption.SO_KEEPALIVE, true);
    }

}
