package com.hengyun.dao.impl.logininfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.hengyun.dao.logininfo.DoctorInfoDao;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.domain.loginInfo.DoctorInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月5日 下午2:49:41
* 医生信息数据访问层
*/
@Repository
public class DoctorInfoDaoImpl  implements DoctorInfoDao{

	@Resource
	 private MongoTemplate mongoTemplate;

	@Resource
	private IndexCollectionDao indexCollectionDao;
	/*
	 *  添加医生信息
	 * 
	 * */
	@Override
	public int addDoctor(DoctorInfo doctorInfo) {
		// TODO Auto-generated method stub
		int doctorId = indexCollectionDao.updateIndex("docterID");
		doctorInfo.setDoctorId(doctorId);
		this.mongoTemplate.save(doctorInfo);
		return doctorId;
	}

	/*
	 * 
	 *  更改医生信息
	 * 
	 * */
	@Override
	public boolean updateDoctor(DoctorInfo doctorInfo) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("doctorId").is(doctorInfo.getDoctorId()));
	
		return false;
	}

	@Override
	public DoctorInfo queryOne(DoctorInfo doctorInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DoctorInfo> query(DoctorInfo doctorInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
