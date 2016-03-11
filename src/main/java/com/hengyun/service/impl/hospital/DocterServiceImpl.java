package com.hengyun.service.impl.hospital;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.hospital.DocterDao;
import com.hengyun.domain.hospital.Docter;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.hospital.DocterService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.UserAccountService;

/*
 *  　医生信息管理
 * */

public class DocterServiceImpl extends BaseServiceImpl<Docter,Integer> implements DocterService{

	@Resource 
	private DocterDao docterDao;

	@Resource
	private UserAccountService userAccountService;
	
	public List<Docter> queryAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("workNum").exists(true));
		return docterDao.queryList(query);
		
	}

	//判断医生工号是否在录入数据库
	@Override
	public boolean exist(String workNum) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("workNum").is(workNum));
		
		try {
			Docter docter = docterDao.queryOne(query);
			if(docter!=null){
			return true;
			}
		} catch (NullPointerException ex) {
			// TODO Auto-generated catch block
			return false;
		}
		return false;
	}

	//查询某个医院的医生
	@Override
	public List<UserAccount> queryByHospital(int hospitalId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("hospitalId").is(hospitalId));
		List<Docter> docterList = docterDao.queryList(query);
		List<UserAccount> users =new ArrayList<UserAccount>();
		for(Docter temp : docterList){
			String workNum = temp.getWorkNum();
			Query query2= Query.query(Criteria.where("workNum").is(workNum));
			UserAccount account = userAccountService.queryOne(query2);
			users.add(account);
		}
		
		return users;
	}
	

}
