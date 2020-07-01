package com.bml.common.registry.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class NettyServerHandler extends ChannelInboundHandlerAdapter implements DoHandlerSoming {

    private Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        if(logger.isDebugEnabled()){
            logger.debug("NettServerHandler.channelActive {} channel is active！",ctx.channel().localAddress().toString());
        }
        doChannelActive(ctx);
        if(logger.isDebugEnabled()){
            logger.debug("NettServerHandler.channelActive  channel do some things is finish！");
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ctx.close();
        if(logger.isDebugEnabled()){
            logger.debug("NettServerHandler.channelInactive {} channel is close！",ctx.channel().localAddress().toString());
        }
        doChannelClose(ctx);
        if(logger.isDebugEnabled()){
            logger.debug("NettServerHandler.channelInactive  channel is close do smth！");
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(logger.isDebugEnabled()){
            logger.debug("NettServerHandler.channelRead  channel is read from to client ！");
        }
        Object response = doReadFromClient(ctx,msg);
        if(logger.isDebugEnabled()){
            logger.debug("NettServerHandler.channelRead  channel invoke return client data {} ！",response);
        }
        if(response != null){
          ctx.writeAndFlush(response);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        if(logger.isDebugEnabled()){
            logger.debug("NettServerHandler.channelReadComplete  server recive data is finish!");
        }
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
