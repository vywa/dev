package com.hengyun.domain.patient;

import java.io.Serializable;

import com.hengyun.domain.casehistory.CaseHistory;
import com.hengyun.domain.information.GeneralPerson;

/*
 *  病人信息表
 * */
public class Patient  extends GeneralPerson implements Serializable{
	

	private CaseHistory	caseHistory;							//病历信息
	
	private PatientTreatInfo 		trateInfo;									//用户就诊信息
	private HealthDateInfo		healthInfo;								//用户健康信息
	
	
	

}
