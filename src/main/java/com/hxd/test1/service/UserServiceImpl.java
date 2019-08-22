package com.hxd.test1.service;

import com.hxd.test1.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserServiceImpl implements UserService {
    private static AtomicInteger count=new AtomicInteger();
    private static Map<Integer,User> map=new ConcurrentHashMap<>();
    @Override
    public List<User> queryAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void insert(User user) {

        if(map.get((user.getId()))==null){
            int id = count.incrementAndGet();
            user.setId(id);
            map.put(id,user);
        }
    }

    @Override
    public void update(User user) {
        map.put(user.getId(),user);
    }

    @Override
    public User queryByID(int id) {
        return map.get(id);
    }

    @Override
    public void delete(User user) {
        map.remove(user.getId());
    }
}
