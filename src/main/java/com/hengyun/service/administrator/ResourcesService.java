package com.hengyun.service.administrator;

import java.util.List;

import com.hengyun.domain.administrator.Permission;
import com.hengyun.domain.administrator.Resources;
import com.hengyun.domain.administrator.Roles;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月23日 上午10:54:40
* 资源业务层
*/
public interface ResourcesService extends BaseService<Resources,Integer>{

	//查看资源
	public List<Resources> queryAllResource();
	
	//添加资源
	public void addResource(Resources resources);

}
