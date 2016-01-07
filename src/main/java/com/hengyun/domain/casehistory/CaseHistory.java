package com.hengyun.domain.casehistory;

import java.io.Serializable;


import com.hengyun.domain.common.GeneralInfo;


/*
 * 	病历基本信息，包括门诊病历首页，病历记录，化验单（检查报告），医学影像检查资料
 * */

public class CaseHistory implements Serializable{

	
	private int id;															//病历编号
	
	
	private String catagory;										//病历类型(门诊，急诊，住院)
	
	private CaseHistoryPreface caseHistoryPreface;				//门诊病历首页
	
	private CaseHistoryContent caseHistoryContent;			//病历记录

	private AnalysisResult	analysisResult;					//检查化验报告
	
	private MedicalVedio		MedicalVedio;						//医学影像资料
	
	private String 					status;										//病历状态（正常，冻结）
	
	
}
