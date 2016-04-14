package com.hengyun.service.casehistory;

import java.util.List;

import com.hengyun.domain.casehistory.SportInfo;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午2:18:08
* 类说明
*/
public interface SportInfoService extends BaseService<SportInfo,Integer>{

	public void addSport(SportInfo sportInfo);
	
	public List<SportInfo> getSportList(int userId);
	
	public void delete(int userId,int id);
}
