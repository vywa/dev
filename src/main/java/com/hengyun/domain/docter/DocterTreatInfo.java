package com.hengyun.domain.docter;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.common.GeneralInfo;

/*
 * 	用户治疗信息
 * */
public class DocterTreatInfo implements Serializable{

	private GeneralInfo generalInfo;					//用户基本信息
	private List<String> docters;							//用户医生列表
	private List<String> caseHistory;					//病历列表
	
	
	
}
