package com.bml.registry.proxy;

import com.bml.common.registry.parameter.ClassRequest;
import com.bml.registry.client.AbstractClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public abstract class AbstractServiceRemoteInvokeByJDKProxy implements InvocationHandler {

    private Logger logger = LoggerFactory.getLogger(AbstractServiceRemoteInvokeByJDKProxy.class);

    public abstract AbstractClient getClient(Object proxy, Method method);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        ClassRequest request = new ClassRequest();
        request.setClassName(className);
        request.setMethodName(methodName);
        request.setParameters(args);
        request.setParametersType(method.getParameterTypes());
        //先暂时默认写死
        AbstractClient client = getClient(proxy,method);
        return client.send(request);
    }
}