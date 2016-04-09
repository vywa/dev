package com.hengyun.service.system;

import com.hengyun.domain.system.AppVersionUpdate;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月9日 下午5:01:22
* 版本更新业务层
*/
public interface AppVersionUpdateService  extends BaseService<AppVersionUpdate,Integer>{

	/*
	 *  查询最新更新
	 * */
	public AppVersionUpdate getLatest(String type);
	
	/*
	 *  添加版本
	 * */
	public void addUpdate(AppVersionUpdate appVersionUpdate);
}
