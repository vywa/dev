package com.hengyun.service.impl.administrator;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.administrator.ResourcesDao;
import com.hengyun.domain.administrator.Permission;
import com.hengyun.domain.administrator.Resources;
import com.hengyun.service.administrator.PermissionService;
import com.hengyun.service.administrator.ResourcesService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.QueryBuilder;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午10:58:02
* 资源业务类
*/
public class ResourcesServiceImpl extends BaseServiceImpl<Resources,Integer> implements ResourcesService{

	private static final Logger log = LoggerFactory.getLogger(ResourcesServiceImpl.class);
	
	@Resource
	private ResourcesDao resourcesDao;
	
	@Resource
	private PermissionService permissionService;
	
	
	// 添加资源
	@Override
	public void addResource(Resources resource) {
		// TODO Auto-generated method stub
		resource.setStatus("normal");
		Date date = new Date();
		resource.setCreateTime(date);
		List<Permission> permissionList =permissionService.queryAll();
		
		resource.setPermissionList(permissionList);
		resourcesDao.save(resource);
		log.info("添加一条资源");
	}

	//查看资源
	@Override
	public List<Resources> queryAllResource() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("resourceId").exists(true));
		List<Resources> resourceList = resourcesDao.queryList(query);
		return resourceList;
	}
	
	//为某个资源添加权限
	@Override
	public void addPermission(Resources resource, Permission permission) {
		// TODO Auto-generated method stub
		
		//Query query = Query.query(Criteria.where("resource"))
		List<Permission> permissionList = resource.getPermissionList();
		permissionList.add(permission);
		resource.setPermissionList(permissionList);
		//构造查询条件字符串
		QueryBuilder queryBuilder = new QueryBuilder();
		queryBuilder.or(new BasicDBObject("name","write"),new BasicDBObject("available","true"));
		
	//	DbObject = match = new DbObject();
		//queryBuilder.elemMatch(match);
		
		//构造返回字段
		BasicDBObject fieldObject=new BasicDBObject();
		fieldObject.put("name", 1);
		fieldObject.put("available", 1);
		
		Query query = new BasicQuery(queryBuilder.get(),fieldObject);
	//	resourceDao.updateFirst(query, update);
	}

	//删除资源对应的权限
	@Override
	public void deletePermission(Resources resource, Permission permission) {
		// TODO Auto-generated method stub
		
	}

	//设置资源对应的权限
	@Override
	public void setPermission(Resources resource, Permission permission) {
		// TODO Auto-generated method stub
		
	}

	//设置资源默认权限
	@Override
	public void initPermission(Resources resource) {
		// TODO Auto-generated method stub
		List<Permission> defaultList = permissionService.queryAll();
		resource.setPermissionList(defaultList);
		Date now = new Date();
		
		resource.setCreateTime(now);
		resource.setLastModifyTime(now);
		resource.setStatus("normal");
		resourcesDao.save(resource);
		
		
	}

	//获取该资源对应的权限列表
	@Override
	public List<Permission> getPermission(Resources resource) {
		// TODO Auto-generated method stub
		List<Permission> permissionList = resource.getPermissionList();
		
		return permissionList;
	}



}
