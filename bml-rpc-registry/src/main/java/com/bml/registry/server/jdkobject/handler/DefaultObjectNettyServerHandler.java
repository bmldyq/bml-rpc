package com.bml.registry.server.jdkobject.handler;

import com.bml.common.registry.handler.NettyServerHandler;
import com.bml.common.registry.parameter.ClassRequest;
import io.netty.channel.ChannelHandlerContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *  netty default class，is operation class and method invoke
 */
public class DefaultObjectNettyServerHandler extends NettyServerHandler {
    @Override
    public void doChannelActive(ChannelHandlerContext ctx) {

    }

    @Override
    public void doChannelClose(ChannelHandlerContext ctx) {

    }

    @Override
    public Object doReadFromClient(ChannelHandlerContext ctx, Object msg) {
        Object result = null;
        ClassRequest param = (ClassRequest) msg;
        String methodName = param.getMethodName();
        String className = param.getClassName();
        try {
            Class<?> clzz = Class.forName(className);
            Object instance =  clzz.newInstance();
            Method method = clzz.getMethod(methodName, param.getParametersType());
            result  = method.invoke(instance, param.getParameters());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}
