package com.hengyun.service.casehistory;

import com.hengyun.domain.casehistory.TargetOrganDamage;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 下午6:11:52
* 靶组织业务
*/
public interface TargetOrganDamageService extends BaseService<TargetOrganDamage,Integer>{

	public boolean add(TargetOrganDamage tod);
	
	public boolean update(TargetOrganDamage tod);
	
	public boolean hasDamage(TargetOrganDamage tod);
}
