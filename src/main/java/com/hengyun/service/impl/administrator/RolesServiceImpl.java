package com.hengyun.service.impl.administrator;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

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

	/*
	 *  查询所有的角色
	 * */
	@Override
	public List<Roles> queryAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("roleId").exists(true));
		List<Roles> rolesList =rolesDao.queryList(query);
		return rolesList;
	}

	/*
	 *  删除角色
	 * */
	@Override
	public void deleteRole(Roles role) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("roleId").is(role.getRoleId()));
		rolesDao.delete(query);
		
	}

	/*
	 *  为某个角色添加资源
	 * */
	@Override
	public void addResource(Roles role, Resources resource) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("roleId").is(role.getRoleId()));
		Roles temp = rolesDao.queryOne(query);
		List<Resources> re = temp.getResourceList();
		boolean exist = false;
		for(Resources rtmp : re){
			if(rtmp.getResourceName().equals(resource.getResourceName())){
				exist = true;
				break;
			}
		}
		
		if(!exist){
			re.add(resource);
			Update update = Update.update("resourceList", re);
			rolesDao.updateFirst(query, update);
		}
	}

	/*
	 *  某个角色删除资源
	 * */
	@Override
	public void deleteResource(Roles role, Resources resource) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("roleId").is(role.getRoleId()));
		Roles temp = rolesDao.queryOne(query);
		List<Resources> re = temp.getResourceList();
		CopyOnWriteArrayList<Resources> cow = new CopyOnWriteArrayList<Resources>(re);
		for(Resources ctemp : cow){
			if(ctemp.getResourceName().equals(resource.getResourceName())){
				cow.remove(ctemp);
				break;
			}
		}
		Update update = Update.update("resourceList", cow);
		rolesDao.updateFirst(query, update);
	}

	/*
	 *  查询角色所有的资源
	 * */
	@Override
	public List<Resources> queryResource(Roles role) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("roleId").is(role.getRoleId()));
		Roles temp = rolesDao.queryOne(query);
		List<Resources> rr = temp.getResourceList();
		return rr;
		
	}

}
