package com.bml.common.registry.handler;

import io.netty.channel.ChannelHandlerContext;

public interface DoHandlerSoming {

    /**
     * channel is active ,do smth
     * @param ctx
     */
     void doChannelActive(ChannelHandlerContext ctx);

    /**
     * channel is close do smth
     * @param ctx
     */
    void doChannelClose(ChannelHandlerContext ctx);

    /**
     * read from request send data
     * @param ctx
     * @param msg
     */
    Object doReadFromClient(ChannelHandlerContext ctx, Object msg);


}
