package com.hengyun.service.impl.information;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.information.InformationDao;
import com.hengyun.domain.common.GeneralInfo;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.information.InformationService;

/*
 *  登陆业务
 * */

public class InformationServiceImpl extends BaseServiceImpl<GeneralInfo,Integer> implements InformationService{

	@Resource 
	private InformationDao informationDao;
	public int edit(GeneralInfo generalInfo) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("userId").is(generalInfo.getUserId()));
		Update update = Update.update("weight", generalInfo.getWeight()).update("age", generalInfo.getAge());
		informationDao.updateFirst(query, update);
		return 0;
	}

}
