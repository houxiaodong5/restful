package com.hxd.test1.service;

import com.hxd.test1.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryAll();
    void insert(User user) ;
    void update(User user);
    User queryByID(int id);
    void delete(User user);

}
