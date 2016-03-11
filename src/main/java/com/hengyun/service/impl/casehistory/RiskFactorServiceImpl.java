package com.hengyun.service.impl.casehistory;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.casehistory.RiskFactorDao;
import com.hengyun.dao.logininfo.IndexCollectiontDao;
import com.hengyun.domain.casehistory.Diagnosis.DangerLevel;
import com.hengyun.domain.casehistory.RiskFactor;
import com.hengyun.service.casehistory.RiskFactorService;
import com.hengyun.service.impl.BaseServiceImpl;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 下午4:10:20
* 危险因素业务访问类
*/
public class RiskFactorServiceImpl extends BaseServiceImpl<RiskFactor,Integer> implements RiskFactorService{

	@Resource
	private RiskFactorDao riskFactorDao;
	
	@Resource
	private IndexCollectiontDao indexCollectionDao;
	
	/*
	 *  添加危险因素
	 * */
	@Override
	public boolean addFactor(RiskFactor riskFactor) {
		// TODO Auto-generated method stub
		int riskFactorId = indexCollectionDao.updateIndex("riskFactorId");
		riskFactor.setRiskFactorId(riskFactorId);
		riskFactorDao.save(riskFactor);
		return true;
	}

	/*
	 *  更新危险因素
	 * */
	@Override
	public boolean updateFactor(RiskFactor riskFactor) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("riskFactorId").is(riskFactor.getRiskFactorId()));
		Update update = Update.update("hightBloodPressure", riskFactor.getHightBloodPressure()).
				addToSet("cigerate", riskFactor.isCigerate()).addToSet("suggerEndure", riskFactor.isSuggerEndure()).
				addToSet("bloodFatException", riskFactor.isBloodFatException()).
				addToSet("vesselherit", riskFactor.isVesselherit()).addToSet("fat", riskFactor.isFat()).
				addToSet("hcy", riskFactor.isHcy()).addToSet("hsCRP", riskFactor.isHsCRP()).
				addToSet("physicalActivity", riskFactor.isPhysicalActivity()).addToSet("age", riskFactor.getAge());
		riskFactorDao.updateFirst(query, update);
		return true;
	}

	/*
	 *  计算危险因素个数
	 * */
	@Override
	public int DagerCount(RiskFactor riskFactor) {
		// TODO Auto-generated method stub
		int count = 0;
		if(riskFactor.getAge()>45) count++;
		if(riskFactor.isBloodFatException()) count++;
		if(riskFactor.isCigerate()) count++;
		if(riskFactor.isFat()) count++;
		if(riskFactor.isHcy()) count++;
		if(riskFactor.isHsCRP()) count++;
		if(riskFactor.isPhysicalActivity()) count++;
		if(riskFactor.isSuggerEndure()) count++;
		if(riskFactor.isVesselherit()) count++;
		
		return count;
	}

	

	
}
