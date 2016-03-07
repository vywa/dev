package com.hengyun.domain.casehistory;

import java.io.Serializable;

/*
 *  入院记录包括：患者一般情况
 * */
public class HospitalRecords implements Serializable{

	private PatientInfo	patientGeneralInfo;					//患者一般情况
	private ChiefComplaint			chiefComplaint;							//主诉
	private PresentDiseaseHistory presentDiseaseHistory;	//现病史
	private PastDiseaseHistory	pastDiseaseHistory;					//既往病史
	private PersonalHistory		personalHistory;						//个人史
	private MarriageHistory		marriageHistory;						//婚育史
	private FamiliyHistory			familyHistory;								//家族史
	
	private PhysicalExamination	physicalExcamination;		//体格检查
	private OfficeSpecialInfo			officeSpecialInfo;					//专科情况
	private AssistExamination		assistExamination;				//辅助检查
	private FirstDiagnosis						firstDiagnosis;				//初诊
	
	private String 								docterName;							//医师签名
	
}
