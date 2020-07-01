package com.bml.registry.proxy.jdkobject;

import com.bml.registry.client.AbstractClient;
import com.bml.registry.client.jdkobject.DefaultObjectNettyClient;
import com.bml.registry.proxy.AbstractServiceRemoteInvokeByJDKProxy;

import java.lang.reflect.Method;

public class DefaultServiceRemoteInvokeByJDKProxy extends AbstractServiceRemoteInvokeByJDKProxy {
    @Override
    public AbstractClient getClient(Object proxy, Method method) {
        return new DefaultObjectNettyClient("127.0.0.1",3000);
    }

}
