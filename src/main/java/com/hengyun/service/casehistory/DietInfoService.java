package com.hengyun.service.casehistory;

import java.util.List;

import com.hengyun.domain.casehistory.DietInfo;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午2:18:22
* 类说明
*/
public interface DietInfoService extends BaseService<DietInfo,Integer>{

public void addDiet(DietInfo dietInfo);
	
	public List<DietInfo> getDietList(int userId);
	
	public void delete(int userId,int id);
}
