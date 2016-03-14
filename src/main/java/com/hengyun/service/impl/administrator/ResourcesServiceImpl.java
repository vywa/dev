package com.hengyun.service.impl.administrator;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.administrator.ResourcesDao;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.domain.administrator.Resources;
import com.hengyun.service.administrator.PermissionService;
import com.hengyun.service.administrator.ResourcesService;
import com.hengyun.service.impl.BaseServiceImpl;
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
	
	@Resource
	private IndexCollectionDao indexCollectionDao;
	
	// 添加资源
	@Override
	public void addResource(Resources resource) {
		// TODO Auto-generated method stub
		resource.setStatus("normal");
		int id = indexCollectionDao.updateIndex("resourceId");
		Date date = new Date();
		resource.setCreateTime(date);
		resource.setLastModifyTime(date);
		resource.setResourceId(id);
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


	

	

}
