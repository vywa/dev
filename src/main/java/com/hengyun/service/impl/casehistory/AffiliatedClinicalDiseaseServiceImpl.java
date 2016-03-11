package com.hengyun.service.impl.casehistory;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.casehistory.AffiliatedClinicalDiseaseDao;
import com.hengyun.dao.logininfo.IndexCollectiontDao;
import com.hengyun.domain.casehistory.AffiliatedClinicalDisease;
import com.hengyun.service.casehistory.AffiliatedClinicalDiseaseService;
import com.hengyun.service.impl.BaseServiceImpl;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月11日 上午9:41:45
* 伴随临床疾患业务实现类
*/
public class AffiliatedClinicalDiseaseServiceImpl extends BaseServiceImpl<AffiliatedClinicalDisease,Integer> implements AffiliatedClinicalDiseaseService{

	@Resource
	private AffiliatedClinicalDiseaseDao affiliatedClinicalDiseaseDao;
	
	@Resource
	private IndexCollectiontDao indexCollectionDao;
	
	/*
	 *  添加记录
	 * */
	@Override
	public boolean add(AffiliatedClinicalDisease affiliatedClinicalDisease) {
		// TODO Auto-generated method stub
		int id = indexCollectionDao.updateIndex("affiliatedClinicalDiseaseId");
		affiliatedClinicalDisease.setAffiliatedClinicalDiseaseId(id);
		affiliatedClinicalDiseaseDao.save(affiliatedClinicalDisease);
		return true;
	}

	/*
	 *  更新记录
	 * */
	@Override
	public boolean update(AffiliatedClinicalDisease affiliatedClinicalDisease) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("affiliatedClinicalDiseaseId").is(affiliatedClinicalDisease.getAffiliatedClinicalDiseaseId()));
		Update update = Update.update("cerebralVascularDisease", affiliatedClinicalDisease.isCerebralVascularDisease()).
				addToSet("cardiovascularDisease", affiliatedClinicalDisease.isCardiovascularDisease()).
				addToSet("kidneyDisease", affiliatedClinicalDisease.isKidneyDisease()).
				addToSet("peripheralVascularDisease", affiliatedClinicalDisease.isPeripheralVascularDisease()).
				addToSet("retinopathy", affiliatedClinicalDisease.isRetinopathy()).
				addToSet("diabetesMelliitus", affiliatedClinicalDisease.isDiabetesMelliitus());
		affiliatedClinicalDiseaseDao.save(affiliatedClinicalDisease);
		return true;
	}

	/*
	 *  是否有临床疾患
	 * */
	@Override
	public boolean hasDisease(AffiliatedClinicalDisease acd) {
		// TODO Auto-generated method stub
		int count = 0;
		if(acd.isCardiovascularDisease()) count++;
		if(acd.isCerebralVascularDisease()) count++;
	//	if(acd.isDiabetesMelliitus()) count++;
		if(acd.isKidneyDisease()) count++;
		if(acd.isPeripheralVascularDisease()) count++;
		if(acd.isRetinopathy()) count++;
		if(count>0){
			return true;
		} else {
			return false;
		}
	}

	/*
	 *  是否有糖尿病
	 * */
	@Override
	public boolean hasDiabetesMelliitus(AffiliatedClinicalDisease affiliatedClinicalDisease) {
		// TODO Auto-generated method stub
		return affiliatedClinicalDisease.isDiabetesMelliitus();
	}

}
