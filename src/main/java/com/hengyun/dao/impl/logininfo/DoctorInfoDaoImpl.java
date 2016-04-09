package com.hengyun.dao.impl.logininfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.logininfo.DoctorInfoDao;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.dao.logininfo.LoginInfoDao;
import com.hengyun.domain.loginInfo.DoctorInfo;
import com.hengyun.domain.loginInfo.LoginInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月5日 下午2:49:41
* 医生信息数据访问层
*/
@Repository
public class DoctorInfoDaoImpl  extends BaseMongodbDaoImpl<DoctorInfo,Integer> implements DoctorInfoDao{

	@Override
	protected Class<DoctorInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return DoctorInfo.class;
	}

	
	
	
}
