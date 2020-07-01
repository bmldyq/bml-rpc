package com.bml.common.registry.channelLizer;

import com.bml.common.registry.handler.NettyServerHandler;
import io.netty.channel.ChannelHandler;

public interface InitLizerChannel<T extends ChannelHandler> {

    T getServerHandler();
}
