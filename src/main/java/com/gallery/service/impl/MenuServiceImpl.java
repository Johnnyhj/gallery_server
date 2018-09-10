package com.gallery.service.impl;

import com.gallery.entity.MenuEntity;
import com.gallery.mapper.MenuMapper;
import com.gallery.mapper.RoleMapper;
import com.gallery.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<MenuEntity> menuList(int id) {
		List<String> idList = roleMapper.getModulesById(id);
		
		String idstemp = "";
		for (String idtemp : idList) {
			idstemp = idstemp + idtemp;
		}
		String[] ids = idstemp.split(";");
		List<MenuEntity> parentMenuList = menuMapper.getParentMenuListById(ids);
		List<MenuEntity> childrenMenuList = menuMapper.getMenuListById(ids);
		List<MenuEntity> menuList = new ArrayList<MenuEntity>();

		for (MenuEntity parentMenu : parentMenuList) {
			List<MenuEntity> menuListTemp = new ArrayList<MenuEntity>();
			for (MenuEntity childrenMenu : childrenMenuList) {
				if (parentMenu.getId() == childrenMenu.getParentId()) {
					menuListTemp.add(childrenMenu);
				}
			}
			parentMenu.setChildren(menuListTemp);
			menuList.add(parentMenu);
		}

		return menuList;
	}

	@Override
	public List<MenuEntity> menusList(int pageSize, int start, String menuId) {
		return menuMapper.menusList(pageSize, start, menuId);
	}

	@Override
	public Integer menusSize(int pageSize, int start, String menuId) {
		return menuMapper.menusSize(pageSize, start, menuId);
	}

	@Override
	public void insertMenu(MenuEntity menuEntity) {
		menuMapper.insertMenu(menuEntity);
	}

	@Override
	public void updateMenu(MenuEntity menuEntity) {
		menuMapper.updateMenu(menuEntity);
	}

	@Override
	public void deleteMenus(List<String> groupId) {
		menuMapper.deleteMenus(groupId);
	}

	@Override
	public List<MenuEntity> menusByParentId(int parentId) {
		return menuMapper.menusByParentId(parentId);
	}

	@Override
	public List<MenuEntity> getSubmenus() {
		return menuMapper.getSubmenus();
	}

}
