package com.hengyun.service.impl.administrator;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.administrator.RolesDao;
import com.hengyun.domain.administrator.Resources;
import com.hengyun.domain.administrator.Roles;
import com.hengyun.service.administrator.ResourcesService;
import com.hengyun.service.administrator.RolesService;
import com.hengyun.service.impl.BaseServiceImpl;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午10:56:44
* 角色业务类
*/
public class RolesServiceImpl extends BaseServiceImpl<Roles,Integer> implements RolesService{

	private static final Logger log = LoggerFactory.getLogger(RolesServiceImpl.class);
	
	@Resource
	private RolesDao rolesDao;
	
	@Resource
	private ResourcesService resourcesService;
	
	//添加角色
	@Override
	public void addRoles(Roles role) {
		// TODO Auto-generated method stub
		List<Resources> resourcesList = resourcesService.queryAllResource();
		role.setResourceList(resourcesList);
		role.setCreateTime(new Date());
		rolesDao.save(role);
		log.info("添加一个角色");
	}

	@Override
	public List<Roles> queryAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("roleId").exists(true));
		List<Roles> rolesList =rolesDao.queryList(query);
		return rolesList;
	}

	@Override
	public void deleteRole(Roles role) {
		// TODO Auto-generated method stub
		
	}

}
