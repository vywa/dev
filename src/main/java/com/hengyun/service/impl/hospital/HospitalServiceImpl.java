package com.hengyun.service.impl.hospital;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.hospital.HospitalDao;
import com.hengyun.domain.hospital.Hospital;
import com.hengyun.service.hospital.HospitalService;
import com.hengyun.service.impl.BaseServiceImpl;

/*
 *  　个人信息管理
 * */

public class HospitalServiceImpl extends BaseServiceImpl<Hospital,Integer> implements HospitalService{

	@Resource 
	private HospitalDao hospitalDao;

	public List<Hospital> queryAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("id").exists(true));
		return hospitalDao.queryList(query);
		
	}
	
	
	

}
