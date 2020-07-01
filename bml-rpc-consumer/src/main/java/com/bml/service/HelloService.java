package com.bml.service;

import com.bml.common.vo.User;

import java.util.List;

public interface HelloService {

    String getMsg();

    User getUser(String userid);

    public List<User> getUserlist();
}
