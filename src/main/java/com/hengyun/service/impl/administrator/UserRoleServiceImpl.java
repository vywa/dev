package com.hengyun.service.impl.administrator;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
	
	//获取资源默认的权限列表
	private List<Permission> getDefaultPermission(Resources resource){
		return null;
	}
	
	//获取角色默认的资源列表
	private List<Resources> getDefaultResource(Roles roles){
		return null;
	}
	
	//获取默认角色
	private List<Roles> getDefaultRoles(){
		return null;
	}
	
	//添加角色
	@Override
	public void addUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("id").is(userRole.getUserId()));
		
		UserAccount userAccount = userAccountService.queryOne(query);
		String catagory = userAccount.getCatagory();
		System.out.println(catagory);
		Query query2 = Query.query(Criteria.where("roleName").is(catagory));
		
		Roles roles = rolesService.queryOne(query2); 
		List<Roles> rolesList = new ArrayList<Roles>();
		rolesList.add(roles);
		userRole.setRoles(rolesList);
		userRoleDao.save(userRole);
		
		log.info("添加用户角色");

		
	}

	//查询用户角色
	@Override
	public List<UserRole> queryAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").exists(true));
		List<UserRole> userRoleList = userRoleDao.queryList(query);
		return userRoleList;
	}
	
	@Override
	public void deleteUserRole(UserRole userRole,Roles role) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userRole").elemMatch(Criteria.where("userId").is(userRole.getUserId())));
		UserRole temp = userRoleDao.queryOne(query);
		
	
	}

	@Override
	public void addResource(UserRole userRole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteResource(UserRole userRole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPermission(UserRole userRole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePermission(UserRole userRole) {
		// TODO Auto-generated method stub
		
	}



}
