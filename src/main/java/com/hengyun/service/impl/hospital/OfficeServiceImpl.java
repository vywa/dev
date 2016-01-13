package com.hengyun.service.impl.hospital;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.hospital.OfficeDao;
import com.hengyun.domain.hospital.Office;
import com.hengyun.service.hospital.OfficeService;
import com.hengyun.service.impl.BaseServiceImpl;

/*
 *  　科室信息管理
 * */

public class OfficeServiceImpl extends BaseServiceImpl<Office,Integer> implements OfficeService{

	@Resource 
	private OfficeDao officeDao;

	public List<Office> queryAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("id").exists(true));
		return officeDao.queryList(query);
		
	}

	public int addDocter(int docterId,int officeId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("officeId").is(officeId));
		Update update = Update.update("docterId", docterId).addToSet("docters", docterId);
		officeDao.updateFirst(query, update);
		return docterId;
	}
	
	

}
