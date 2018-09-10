package com.gallery.mapper;
import com.gallery.entity.UserEntity;

public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer userId);

    UserEntity selectByLoginName(String loginName);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}