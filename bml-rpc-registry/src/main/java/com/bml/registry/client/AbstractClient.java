package com.bml.registry.client;

import com.bml.common.registry.parameter.ClassRequest;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractClient {
    private Logger logger = LoggerFactory.getLogger(AbstractClient.class);


    protected abstract ChannelInitializer<SocketChannel> getChannelInitlizerInstance();
    protected abstract String getIp();
    protected abstract int getProt();
    protected abstract  Object getResponse();
    public Object send(ClassRequest request){
            EventLoopGroup group = new NioEventLoopGroup();
            try{
                // 创建并初始化 Netty 客户端 Bootstrap 对象
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(group);
                bootstrap.channel(NioSocketChannel.class);
                bootstrap.handler(getChannelInitlizerInstance());
                bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
                // 连接 RPC 服务器
                ChannelFuture future = bootstrap.connect(getIp(), getProt()).sync();
                if(logger.isInfoEnabled()){
                    logger.info("client connec to server is success!");
                }
                // 写入 RPC 请求数据并关闭连接
                future.channel().writeAndFlush(request);
                if(logger.isInfoEnabled()){
                    logger.info("client send data is success!");
                }
                future.channel().closeFuture().sync();
            }catch (Exception ce){
                ce.printStackTrace();
            }finally {
                group.shutdownGracefully();
            }
        return getResponse();
    }
}
