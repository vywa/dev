package com.hengyun.dao.impl.logininfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.dao.logininfo.PatientInfoDao;
import com.hengyun.domain.loginInfo.PatientInfo;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月5日 下午2:47:40
* 病人信息数据访问层
*/
@Repository
public class PatientInfoDaoImpl  extends BaseMongodbDaoImpl<PatientInfo,Integer> implements PatientInfoDao{

	@Override
	protected Class<PatientInfo> getEntityClass() {
		// TODO Auto-generated method stub
		return PatientInfo.class;
	}

	
	

}
