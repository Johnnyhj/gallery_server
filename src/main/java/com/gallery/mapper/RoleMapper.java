package com.gallery.mapper;

import com.gallery.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface RoleMapper {
	/**
	 * 获取role列表
	 * @param pageSize
	 * @param start
	 * @return
	 */
	public ArrayList<RoleEntity> rolesList(@Param("pageSize") int pageSize, @Param("start") int start);

	/**
	 * 获取role列表的总量
	 * @param pageSize
	 * @param start
	 * @return
	 */
	public Integer rolesSize(@Param("pageSize") int pageSize, @Param("start") int start);

	/**
	 * 新建角色信息
	 * @param roleEntityEntity
	 */
	public void insertRole(@Param("roleEntityEntity") RoleEntity roleEntityEntity);

	/**
	 * 更新角色信息
	 * @param roleEntityEntity
	 */
	public void updateRole(@Param("roleEntityEntity") RoleEntity roleEntityEntity);

	/**
	 * 删除角色信息
	 * @param groupId
	 */
	public void deleteRoles(@Param("groupId") List<String> groupId);
	
	/**
	 * 通过id得到Modules集合
	 * @param id
	 * @return
	 */
	public List<String> getModulesById(@Param("id") int id);

	/**
	 * 得到角色全部数据
	 * @return
	 */
	public List<RoleEntity> allRoles();

	/**
	 * 通过UserId得到对应的role
	 * @param id
	 * @return
	 */
	public List<String> getRolesByUserId(int id);
}
