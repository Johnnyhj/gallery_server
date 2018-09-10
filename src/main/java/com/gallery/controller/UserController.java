package com.gallery.controller;

import com.gallery.entity.UserEntity;
import com.gallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @ClassName com.album.controller
 * @Date 2018年09月05日 10时32分
 * @Author johnnyhj@qq.com
 * @Copyright (c) All Rights Reserved, 2018.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{loginName}")
    public UserEntity userGet(@PathVariable String loginName) {
        UserEntity userEntityEntity = userService.selectUserByLoginName(loginName);
        return userEntityEntity;
    }

    /**
     * 新建用户信息
     *
     * @param userEntity
     * @return
     */
    @PostMapping("/insertUser")
    public UserEntity insertUser(@RequestBody UserEntity userEntity) {
        userService.insert(userEntity);
        return userEntity;
    }

}
