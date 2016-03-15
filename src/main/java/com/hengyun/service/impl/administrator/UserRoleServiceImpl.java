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
	 *  注册时添加角色表
	 * */
	@Override
	public void addUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userRole.getUserId()));
		Query query2 = Query.query(Criteria.where("roleName").is(userRole.getRoleName()));

			List<Resources> rlist = rolesService.queryOne(query2).getResourceList();
			userRole.setResourceList(rlist);
			userRoleDao.save(userRole);
	
	}

	/*
	 *  查询用户
	 * */
	@Override
	public UserRole  query(int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		UserRole userRole = userRoleDao.queryOne(query);
		return userRole;
	
	}

	
	/*
	 *  给用户添加资源
	 * */
	@Override
	public void addResource(Resources resources, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		List<Resources> rlist = userRoleDao.queryOne(query).getResourceList();
		boolean exist = false;
		for(Resources temp : rlist){
			if(temp.getResourceName().equals(resources.getResourceName())){
				exist = true;
				break;
			}
		}
		if(!exist){
			rlist.add(resources);
			Update update = Update.update("resourceList", rlist);
			userRoleDao.updateFirst(query, update);
			log.info("用户添加了一个资源权限");
		}
	}

	/*
	 *  给用户删除资源
	 * */
	@Override
	public void deleteResource(Resources resources, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		List<Resources> rlist = userRoleDao.queryOne(query).getResourceList();
		CopyOnWriteArrayList<Resources> cow = new CopyOnWriteArrayList<Resources>(rlist);
		for(Resources temp : cow){
			if(temp.getResourceName().equals(resources.getResourceName())){
				cow.remove(temp);
				break;
			}
		}
		Update update = Update.update("resourceList", cow);
		userRoleDao.updateFirst(query, update);
		log.info("用户删除了一个资源权限");
	}

	/*
	 *  用户是否拥有该资源
	 * */
	@Override
	public boolean hasResource(Resources resource, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(userId));
		List<Resources> rlist = userRoleDao.queryOne(query).getResourceList();
		boolean hasResources = false;
		for(Resources temp :rlist){
			if(temp.getResourceName().equals(resource.getResourceName())){
				hasResources = true;
				break;
			}
		}
		return hasResources;
	}
	
	
	

}
