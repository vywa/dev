package com.hengyun.domain.docter;

import java.io.Serializable;

import com.hengyun.domain.casehistory.CaseHistory;
import com.hengyun.domain.common.GeneralPerson;
import com.hengyun.domain.patient.Patient;

/*
 * 医生信息表 
 * */


public class Docter extends GeneralPerson implements Serializable{

	private CaseHistory	caseHistory;							//病历信息	
	private DocterTreatInfo 		trateInfo;									//医生会诊诊信息
	private Patient				patient;										//病人列表


}
