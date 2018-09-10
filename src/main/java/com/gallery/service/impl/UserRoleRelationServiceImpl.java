package com.gallery.service.impl;

import com.gallery.entity.UserRoleRelationEntity;
import com.gallery.mapper.UserRoleRelationMapper;
import com.gallery.service.UserRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "relationServiceImpl")
public class UserRoleRelationServiceImpl implements UserRoleRelationService {

	@Autowired
	private UserRoleRelationMapper userRoleRelationMapper;

	@Override
	public List<UserRoleRelationEntity> getRelationByUserId(int userId) {
		return userRoleRelationMapper.getRelationByUserId(userId);
	}

	@Transactional
	@Override
	public void insertRelations(List<UserRoleRelationEntity> relationList) {
		userRoleRelationMapper.delById(relationList.get(0).getUserId());
		if (relationList.get(0).getRoleId() != null) {
			userRoleRelationMapper.insertRelations(relationList);
		}
	}

}
