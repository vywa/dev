package com.hengyun.service.impl.administrator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.administrator.UserRoleDao;
import com.hengyun.domain.administrator.Permission;
import com.hengyun.domain.administrator.Resources;
import com.hengyun.domain.administrator.Roles;
import com.hengyun.domain.administrator.UserRole;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.administrator.RolesService;
import com.hengyun.service.administrator.UserRoleService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.UserAccountService;
import com.mongodb.BasicDBObject;
import com.mongodb.QueryBuilder;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午10:22:09
* 用户角色资源业务层
*/
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole,Integer> implements UserRoleService{

	private static final Logger log = LoggerFactory.getLogger(UserRoleServiceImpl.class);
	@Resource
	private UserRoleDao userRoleDao;
	
	@Resource
	private RolesService rolesService;
	
	@Resource
	private UserAccountService userAccountService;

	/*
	 *  添加角色表
	 * */
	@Override
	public void addUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		
	}

	/*
	 *  给用户添加资源
	 * */
	@Override
	public void addResource(Resources resources, int userId) {
		// TODO Auto-generated method stub
		
	}

	/*
	 *  给用户删除资源
	 * */
	@Override
	public void deleteResource(Resources resources, int userId) {
		// TODO Auto-generated method stub
		
	}

	/*
	 *  用户是否
	 * */
	@Override
	public boolean hasResource(Resources resource, int userId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
