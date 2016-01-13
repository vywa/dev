package com.hengyun.dao.impl.hospital;

import com.hengyun.dao.hospital.OfficeDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.hospital.Office;




public class OfficeDaoImpl extends BaseMongodbDaoImpl<Office,Integer> implements OfficeDao{


	@Override
	protected Class<Office> getEntityClass() {
		// TODO Auto-generated method stub
		return Office.class;
	}
	
    
}
