package com.hengyun.service.impl.administrator;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.administrator.PermissionDao;
import com.hengyun.domain.administrator.Permission;
import com.hengyun.service.administrator.PermissionService;
import com.hengyun.service.impl.BaseServiceImpl;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午11:19:22
* 权限操作接口
*/
public class PermissionServiceImpl extends BaseServiceImpl<Permission,Integer> implements PermissionService{

	@Resource
	private PermissionDao permissionDao;
	
	@Override
	public void addPermission(Permission permission) {
		// TODO Auto-generated method stub
		permissionDao.save(permission);
	}

	@Override
	public void deletePermission(Permission permission) {
		// TODO Auto-generated method stub
		permissionDao.delete(permission);
	}

	@Override
	public void updatePermission(Permission permission) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("permissionId").exists(true).andOperator(Criteria.where("permissionId").is(permission.getPermissionId())));
		Update update = Update.update("name", permission.getName()).set("description", permission.getDescription()).set("available", permission.isAvailable());
		permissionDao.updateFirst(query, update);
	}

	@Override
	public Permission queryPermission(Permission permission) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("name").is(permission.getName()));
		Permission result = permissionDao.queryOne(query);
		return permission;
	}

	@Override
	public List<Permission> queryAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("permissionId").exists(true));
		List<Permission> permissionList = permissionDao.queryList(query);
		return permissionList;
	}

}

