package com.bml.service;

import com.bml.common.vo.User;

import java.util.ArrayList;
import java.util.List;

public class HelloService {

    public String getMsg(){
        System.out.println("111111111111111111");
        return "I am baml";
    }

    public User getUser(String userid){
        System.out.println("用户 "+userid +" 发送查询用户信息请求");
        User user = new User();
        user.setAddr("四川省成都市");
        user.setAge(34);
        user.setUserId(userid);
        user.setUserName("baiml");
        return user;
    }
    public List<User> getUserlist(){
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAddr("四川省成都市温江区");
        user.setAge(34);
        user.setUserId("001");
        user.setUserName("baiml");
        list.add(user);
        user = new User();
        user.setAddr("四川省成都市犀浦");
        user.setAge(32);
        user.setUserId("002");
        user.setUserName("chenhuan");
        list.add(user);
        user = new User();
        user.setAddr("四川省成都市锦江区");
        user.setAge(32);
        user.setUserId("003");
        user.setUserName("abc");
        list.add(user);
        return list;
    }
}
