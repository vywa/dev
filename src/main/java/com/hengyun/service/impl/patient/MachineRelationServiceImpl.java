package com.hengyun.service.impl.patient;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.patient.MachineRelationDao;
import com.hengyun.domain.patient.MachineRelation;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.patient.MachineRelationService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月10日 上午11:51:23
* 
*/
public class MachineRelationServiceImpl  extends BaseServiceImpl<MachineRelation,Integer> implements MachineRelationService{

	@Resource
	private MachineRelationDao machieRelationDao;
	//获取用户
	@Override
	public int getUser(String serial, int user) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("serial").is(serial).andOperator(Criteria.where("user")));
		MachineRelation mr = machieRelationDao.queryOne(query);
		if(mr!=null) return mr.getUserId();
		return -1;
	}
	
	//绑定用户
	@Override
	public void bind(int userId, String seria, int user) {
		// TODO Auto-generated method stub
		MachineRelation mr = new MachineRelation();
		mr.setUserId(userId);
		mr.setUser(user);
		mr.setSerial(seria);
		machieRelationDao.save(mr);
		
	}
	
	//解绑用户
	@Override
	public void unbind(int userId, String seria) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("serial").is(seria).andOperator(Criteria.where("user")));
		machieRelationDao.delete(query);
	}

	
	
	
	

}
