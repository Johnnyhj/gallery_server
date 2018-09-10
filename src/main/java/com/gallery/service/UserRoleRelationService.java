package com.gallery.service;


import com.gallery.entity.UserRoleRelationEntity;

import java.util.List;

public interface UserRoleRelationService {

	/**
	 * 通过userId得到关系List
	 * @param userId
	 * @return
	 */
	public List<UserRoleRelationEntity> getRelationByUserId(int userId);

	/**
	 * 批量插入关系数据
	 * @param relationList
	 */
	public void insertRelations(List<UserRoleRelationEntity> relationList);

	
}
