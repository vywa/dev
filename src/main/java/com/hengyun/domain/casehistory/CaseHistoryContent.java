package com.hengyun.domain.casehistory;

import java.util.Date;

import com.hengyun.domain.hospital.AdministrativeOffice;

/*
 * 
 *  病历记录（初诊病历记录和复诊病历记录）
 *  
 *  初诊病历记录包括就诊时间、科别、主诉、现病史、既往史，阳性体征、必要的阴性体征和辅助检查结果，诊断及治疗意见和医师签名等。
 *  
 *  复诊病历记录书写内容应当包括就诊时间、科别、主诉、病史、必要的体格检查和辅助检查结果、诊断、治疗处理意见和医师签名等。
 *  
 *  急诊病历书写就诊时间应当具体到分钟。
 * 
 * */

public class CaseHistoryContent {

	private Date treatTime;					//就诊时间
	private AdministrativeOffice  administrativeOffice;			//科室信息
	private ChiefComplaint chiefComplaint;								//主诉
	private PresentDiseaseHistory presentDiseaseHistory;		//现病史
	private PastDiseaseHistory		pastDiseaseHistory;					//既病史
	private String			positiveSigns;										//阳性体征
	private String		negativeSigns;									//	阴性体征
	private AssistExamination	assistExamination;						//辅助检查结果
	private DiagnosisResult		diagnosisResult;							//诊断
	private DocterAdvice					docterAdvice;										//治疗意见
	
	private String 						docterName;										//医生签名
	
	
	
}
