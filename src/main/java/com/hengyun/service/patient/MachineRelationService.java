package com.hengyun.service.patient;

import com.hengyun.domain.patient.MachineRelation;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月10日 上午11:50:39
* 类说明
*/
public interface MachineRelationService extends BaseService<MachineRelation,Integer>{

	public int getUser(String serial,int user);
	
	public void bind(int userId,String seria,int user);
	
	public void unbind( int userId,String seria);
}
