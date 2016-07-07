package com.hengyun.service.patient;

import com.hengyun.domain.patient.SNMacRelation;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月13日 下午4:53:40
* 类说明
*/
public interface SNMacRelationService extends BaseService<SNMacRelation,Integer>{

	public void add(SNMacRelation snMacRelation);
	
	public String getSN(String mac);
}
