package com.hengyun.service.impl.casehistory;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.casehistory.TargetOrganDamageDao;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.domain.casehistory.TargetOrganDamage;
import com.hengyun.service.casehistory.TargetOrganDamageService;
import com.hengyun.service.impl.BaseServiceImpl;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月11日 上午9:00:40
* 靶组织
*/
public class TargetOrganDamageServiceImpl extends BaseServiceImpl<TargetOrganDamage,Integer> implements TargetOrganDamageService{

	@Resource
	private TargetOrganDamageDao targetOrganDamageDao;
	
	@Resource
	private IndexCollectionDao indexCollectionDao;
	
	/*
	 *  添加记录
	 * */
	@Override
	public boolean add(TargetOrganDamage tod) {
		// TODO Auto-generated method stub
		int id = indexCollectionDao.updateIndex("targetOrganDamageId");
		tod.setTargetOrganDamageId(id);
		targetOrganDamageDao.save(tod);
		return true;
	}

	/*
	 *  更新记录
	 * */
	@Override
	public boolean update(TargetOrganDamage tod) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("targetOrganDamageId").is(tod.getTargetOrganDamageId()));
		Update update = Update.update("leftVentricularHypertrophy", tod.isLeftVentricularHypertrophy()).
				addToSet("neckArteries", tod.isNeckArteries()).addToSet("ankleArteries", tod.isAnkleArteries()).
				addToSet("limbArteries", tod.isLimbArteries()).addToSet("kidneyBall", tod.isKidneyBall()).addToSet("urineProtein", tod.isUrineProtein());
		targetOrganDamageDao.updateFirst(query, update);
		return true;
	}

	/*
	 *  是否有组织受伤
	 * */
	@Override
	public boolean hasDamage(TargetOrganDamage tod) {
		// TODO Auto-generated method stub
		int count = 0;
		if(tod.isAnkleArteries()) count++;
		if(tod.isKidneyBall()) count++;
		if(tod.isLeftVentricularHypertrophy()) count++;
		if(tod.isLimbArteries()) count++;
		if(tod.isNeckArteries()) count++;
		if(tod.isUrineProtein()) count++;
		if(count>0) {
			return true;
		} else {
			return false;
		}
	}

}
