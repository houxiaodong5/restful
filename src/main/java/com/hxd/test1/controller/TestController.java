package com.hxd.test1.controller;

import com.hxd.test1.entity.User;
import com.hxd.test1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class TestController {
    @Autowired
    private UserService userService;

    /**
     * 无返回值：ResultEntity<Void>
     */
    @PostMapping("/rest/user")
    public ResponseEntity<Void> test(@RequestBody User user) {
        try {
            System.out.println("---------插入操作-----------");
            userService.insert(user);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }


    }

    /**
     * 查询操作：返回值 ResultEntity<User>
     */
    @GetMapping("/rest/user")
    public ResponseEntity<List<User>> test1() {
        try {
            System.out.println("---------查询操作-----------");
            return ResponseEntity.ok(userService.queryAll());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }


    /**
     *  204 No Content :成功状态响应码表示目前请求成功，但客户端不需要更新其现有页面  put->204->update
     *  201 Created :是一个代表成功的应答状态码，表示请求已经被成功处理，并且创建了新的资源 post->201->insert
     *
     *
     * */


}
