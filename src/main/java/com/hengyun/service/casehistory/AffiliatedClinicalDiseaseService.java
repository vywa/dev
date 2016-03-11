package com.hengyun.service.casehistory;

import com.hengyun.domain.casehistory.AffiliatedClinicalDisease;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月11日 上午9:37:30
* 伴随临床疾患
*/
public interface AffiliatedClinicalDiseaseService extends BaseService<AffiliatedClinicalDisease,Integer>{

	public boolean add(AffiliatedClinicalDisease affiliatedClinicalDisease);
	
	public boolean update(AffiliatedClinicalDisease affiliatedClinicalDisease);
	
	public boolean hasDisease(AffiliatedClinicalDisease affiliatedClinicalDisease);
	
	public boolean hasDiabetesMelliitus(AffiliatedClinicalDisease affiliatedClinicalDisease);
}
