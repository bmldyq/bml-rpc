package com.bml.registry.proxy;

import com.bml.registry.proxy.jdkobject.DefaultServiceRemoteInvokeByJDKProxy;

import java.lang.reflect.Proxy;

public class ServiceExecute {


    public static <T> T getService(Class<? extends T> clzz){
        ClassLoader loader = clzz.getClassLoader();
        Class<?> [] interfaces = new Class[] {clzz};
        return (T) Proxy.newProxyInstance(loader,interfaces,new DefaultServiceRemoteInvokeByJDKProxy());
    }
}
