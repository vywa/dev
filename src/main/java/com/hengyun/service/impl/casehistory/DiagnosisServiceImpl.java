package com.hengyun.service.impl.casehistory;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.casehistory.DiagnosisDao;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.domain.casehistory.AffiliatedClinicalDisease;
import com.hengyun.domain.casehistory.CaseHistory;
import com.hengyun.domain.casehistory.Diagnosis;
import com.hengyun.domain.casehistory.Diagnosis.DangerLevel;
import com.hengyun.domain.casehistory.RiskFactor;
import com.hengyun.domain.casehistory.TargetOrganDamage;
import com.hengyun.service.casehistory.AffiliatedClinicalDiseaseService;
import com.hengyun.service.casehistory.CaseHistoryService;
import com.hengyun.service.casehistory.DiagnosisService;
import com.hengyun.service.casehistory.RiskFactorService;
import com.hengyun.service.casehistory.TargetOrganDamageService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.patient.BloodPressureInfoService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月10日 上午10:01:29
*  诊断结果业务类
*/
public class DiagnosisServiceImpl extends BaseServiceImpl<Diagnosis,Integer> implements DiagnosisService{

	@Resource
	private DiagnosisDao diagnosisDao;
	
	@Resource
	private IndexCollectionDao indexCollectionDao;

	@Resource
	private RiskFactorService riskFactorService;
	
	@Resource
	private TargetOrganDamageService targetOrganDamangeService;
	
	@Resource
	private AffiliatedClinicalDiseaseService affiliatedClinicalDiseaseService;
	
	@Resource
	private BloodPressureInfoService bloodPressureInfoService;
	
	@Resource
	private CaseHistoryService caseHistoryService;
	/*
	 *  评估危险等级
	 * */
	@Override
	public DangerLevel assess(int caseHistoryId) {
		// TODO Auto-generated method stub
		CaseHistory caseHistory = caseHistoryService.query(caseHistoryId);
		RiskFactor riskFactor = caseHistory.getRiskFactor();
		TargetOrganDamage tod = caseHistory.getTargetOrganDamage();
		AffiliatedClinicalDisease acd = caseHistory.getAffiliatedClinicalDisease();
		int userId = caseHistory.getPatientId();
		//int bloodLevel = riskFactor.getHightBloodPressure();
		int bloodLevel = bloodPressureInfoService.getLevel(userId);

		int riskCount = riskFactorService.DagerCount(riskFactor);
		boolean damage = targetOrganDamangeService.hasDamage(tod);
		boolean diabetesMelliitus = affiliatedClinicalDiseaseService.hasDiabetesMelliitus(acd);
		boolean affiliated = affiliatedClinicalDiseaseService.hasDisease(acd);
		DangerLevel danger = null;
		switch(bloodLevel){
		case 0:
		
		case 1:
			if(riskCount <=0) {
				danger = DangerLevel.little_danger;
			}  if(riskCount<=2){
				danger = DangerLevel.moderate_danger;
			}  if(riskCount>=3 || damage ||diabetesMelliitus ){
				danger = DangerLevel.more_danger;
			}  if(affiliated){
				danger = DangerLevel.most_danger;
			}
			break;
		case 2:
			if(riskCount <=0) {
				danger = DangerLevel.moderate_danger;
			}  if(riskCount<=2){
				danger = DangerLevel.moderate_danger;
			}  if(riskCount>=3 || damage ||diabetesMelliitus ){
				danger = DangerLevel.more_danger;
			}  if(affiliated){
				danger = DangerLevel.most_danger;
			}
			break;
		case 3:
			if(riskCount <=0) {
				danger = DangerLevel.more_danger;
			}  if(riskCount<=2){
				danger = DangerLevel.more_danger;
			}  if(riskCount>=3 || damage ||diabetesMelliitus ){
				danger = DangerLevel.more_danger;
			}  if(affiliated){
				danger = DangerLevel.most_danger;
			}
			break;
			default:
				danger=DangerLevel.unknown;
				break;
		}
		
		return danger;
	}

	/*
	 *  存储评估结果
	 * */
	@Override
	public boolean storeDanger(Diagnosis diagnosis) {
		// TODO Auto-generated method stub
		int id = indexCollectionDao.updateIndex("diagnosisId");
	
		diagnosisDao.save(diagnosis);
		return true;
	}

	/*
	 *  查询诊断结果
	 * */
	@Override
	public Diagnosis query(int diagnosisId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("diagnosisId").is(diagnosisId));
		Diagnosis diagnosis = diagnosisDao.queryOne(query);
		if(diagnosis != null) {
			return diagnosis;
		} else {
			return null;
		}
	}
	


}
