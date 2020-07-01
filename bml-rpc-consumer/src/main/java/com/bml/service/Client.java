package com.bml.service;

import com.bml.common.vo.User;
import com.bml.registry.proxy.ServiceExecute;

import java.util.List;

public class Client {

    public static void main(String[] args) {

       HelloService service =  ServiceExecute.getService(HelloService.class);
       String msg = service.getMsg();
       System.out.println("str="+msg);

        User user = service.getUser("001");
        System.out.println("user="+user.toString());

        List<User> list = service.getUserlist();
        System.out.println("list="+list);
    }
}
