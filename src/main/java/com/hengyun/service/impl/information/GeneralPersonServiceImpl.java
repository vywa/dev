package com.hengyun.service.impl.information;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.information.GeneralPersonDao;
import com.hengyun.dao.information.InformationDao;
import com.hengyun.domain.information.GeneralPerson;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.information.GeneralPersonService;
import com.hengyun.service.logininfo.LoginInfoService;

/*
 *  　个人信息管理
 * */

public class GeneralPersonServiceImpl extends BaseServiceImpl<GeneralPerson,Integer> implements GeneralPersonService{

	@Resource 
	private InformationDao informationDao;
	@Resource
	
	private LoginInfoService loginInfoService;
	
	@Resource
	private GeneralPersonDao generalPersonDao;
	
	//添加资料
	public int add(GeneralPerson generalPerson) {
		// TODO Auto-generated method stub
		
			generalPersonDao.save(generalPerson);
			return 0;
		
	}
	
	
	public List<GeneralPerson> show(){
		Query query = new Query();
		query.addCriteria(Criteria.where("id").exists(true));
		return generalPersonDao.queryList(query);
	}

}
