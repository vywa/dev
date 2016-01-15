package com.hengyun.dao.impl.information;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.information.GeneralPersonDao;
import com.hengyun.domain.information.GeneralPerson;


/*
 *  上传文件
 * */

public class GeneralPersonDaoImpl extends BaseMongodbDaoImpl<GeneralPerson,Integer> implements GeneralPersonDao{

	@Override
	protected Class<GeneralPerson> getEntityClass() {
		// TODO Auto-generated method stub
		return GeneralPerson.class;
	}

    
}
