package com.bml.common.registry.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class NettyClientHandler extends SimpleChannelInboundHandler implements DoHandlerSoming {

    public abstract  void setResponse(Object msg);
    private Logger logger = LoggerFactory.getLogger(NettyClientHandler.class);
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        if(logger.isDebugEnabled()){
            logger.debug("NettyClientHandler.channelActive client is active {}",ctx.channel().localAddress());
        }
        doChannelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        if(logger.isDebugEnabled()){
            logger.debug("NettyClientHandler.channelActive client is close ");
        }
        doChannelClose(ctx);

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(logger.isDebugEnabled()){
            logger.debug("NettyClientHandler.channelRead0  channel is read from to server ！");
        }
        Object response = doReadFromClient(ctx,msg);
        if(logger.isDebugEnabled()){
            logger.debug("NettyClientHandler.channelRead0  channel invoke return client data {} ！",response);
        }
        setResponse(response);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
        if(logger.isDebugEnabled()){
            logger.debug("NettyClientHandler.channelReadComplete  data is recive finish！");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}
