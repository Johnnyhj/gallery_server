package com.gallery.service.impl;

import com.gallery.entity.RoleEntity;
import com.gallery.mapper.RoleMapper;
import com.gallery.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "roleServiceImpl")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<RoleEntity> rolesList(int pageSize, int start) {
		return roleMapper.rolesList(pageSize, start);
	}

	@Override
	public Integer rolesSize(int pageSize, int start) {
		return roleMapper.rolesSize(pageSize, start);
	}

	@Override
	public void insertRole(RoleEntity roleEntity) {
		roleMapper.insertRole(roleEntity);
	}

	@Override
	public void updateRole(RoleEntity roleEntity) {
		roleMapper.updateRole(roleEntity);
	}

	@Override
	public void deleteRoles(List<String> groupId) {
		roleMapper.deleteRoles(groupId);
	}

	@Override
	public List<RoleEntity> allRoles() {
		return roleMapper.allRoles();
	}

}
