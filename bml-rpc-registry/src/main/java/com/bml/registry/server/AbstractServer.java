package com.bml.registry.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractServer extends NettyConfiguration {
        private Logger logger = LoggerFactory.getLogger(AbstractServer.class);
        /**
         * get Netty Server port
         * @return
         */
        protected abstract  int  getServerPort();

    /**
     * init ChannelInitlizer
     * @return
     */
    protected abstract ChannelInitializer<SocketChannel> getChannelInitlizerInstance();

    public void star(){
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try{

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workGroup);
            super.setNettyServerOption(bootstrap);
            bootstrap.childHandler(getChannelInitlizerInstance());
            ChannelFuture future =  bootstrap.bind(getServerPort()).sync();
            if(logger.isInfoEnabled()){
                logger.info("AbstractServer.start netty server is string on {}... ",getServerPort());
            }
            future.channel().closeFuture().sync();
            if(logger.isInfoEnabled()){
                logger.info("AbstractServer.start netty server is stop... ");
            }
        }catch ( Exception e){
            e.printStackTrace();
        }finally{
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }



    }


}
