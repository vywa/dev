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
 * 
 *  　医院信息管理业务类
 *  
 * */

public class HospitalServiceImpl extends BaseServiceImpl<Hospital,Integer> implements HospitalService{

	@Resource 
	private HospitalDao hospitalDao;

	public List<Hospital> queryAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("id").exists(true));
		return hospitalDao.queryList(query);
		
	}

	@Override
	public void addHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		String hospitalName = hospital.getHospitalName();
		String temp = hospitalName.substring(10);
		hospital.setShortName(temp);
		hospitalDao.save(hospital);
	}
	
	
	

}
