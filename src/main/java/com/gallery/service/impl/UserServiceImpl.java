package com.gallery.service.impl;

import com.gallery.entity.UserEntity;
import com.gallery.mapper.UserMapper;
import com.gallery.service.UserService;
import com.gallery.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Description
 * @ClassName com.album.service.impl
 * @Date 2018年09月05日 10时27分
 * @Author johnnyhj@qq.com
 * @Copyright (c) All Rights Reserved, 2018.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public int insert(UserEntity userEntity) {
        logger.info("开始插入用户信息: " + userEntity);
        userEntity.setCreateTime(DateUtil.getToday());
        userEntity.setPassword("{bcrypt}"+new BCryptPasswordEncoder().encode(userEntity.getPassword()));
        return userMapper.insert(userEntity);
    }

    @Override
    public UserEntity selectUserByLoginName(String loginName) {
        return userMapper.selectByLoginName(loginName);
    }
}
