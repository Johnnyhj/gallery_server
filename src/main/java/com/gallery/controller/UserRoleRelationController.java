package com.gallery.controller;

import com.gallery.entity.UserRoleRelationEntity;
import com.gallery.service.UserRoleRelationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserRoleRelationController {

	private Logger log = LoggerFactory.getLogger(UserRoleRelationController.class);

	@Resource(name = "relationServiceImpl")
	private UserRoleRelationService relationService;

	/**
	 * 通过userId得到关系List
	 * @param userId
	 * @return
	 */
	@GetMapping("/relations/{userId}")
	public List<UserRoleRelationEntity> getRelationByUserId(@PathVariable int userId){
		log.debug("The method is ending");
		return relationService.getRelationByUserId(userId);
	}
	
	/**
	 * 批量插入关系数据
	 * @param relationList
	 * @return
	 */
	@PostMapping("/relations")
	public List<UserRoleRelationEntity> insertRelations(@RequestBody() List<UserRoleRelationEntity> relationList){
		relationService.insertRelations(relationList);
		log.debug("The method is ending");
		return relationList;
	}
}
