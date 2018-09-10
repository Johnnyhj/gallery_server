package com.gallery.service;

import com.gallery.entity.UserEntity;

/**
 * @Description
 * @ClassName com.album.service
 * @Date 2018年09月05日 10时25分
 * @Author johnnyhj@qq.com
 * @Copyright (c) All Rights Reserved, 2018.
 */
public interface UserService {
    public int insert(UserEntity userEntity);

    public UserEntity selectUserByLoginName(String loginName);
}
