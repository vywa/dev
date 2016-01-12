package com.hengyun.domain.patient;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.information.Information;

/*
 * 	病人就诊信息
 * */
public class PatientTreatInfo implements Serializable{

	private Information generalInfo;					//用户基本信息
	
	private List<String> docters;							//医生病人列表
	private List<String> caseHistory;					//病历列表
	
	
}
