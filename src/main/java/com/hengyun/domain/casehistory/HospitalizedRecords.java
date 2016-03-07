package com.hengyun.domain.casehistory;

import java.io.Serializable;

/*
 * 住院病历
 * 住院病案首页、入院记录、病程记录、手术同意书、麻醉同意书、输血治疗知情同意书、
 * 特殊检查(特殊治疗)同意书、病危(重)通知书、医嘱单、辅助检查报告单、体温单、医学影像检查资料、病理资料等。
 * */

public class HospitalizedRecords implements Serializable{

	private HospitalizedRecordPreface hospitalizedRecordPreface;			//住院病历首页
	private HospitalRecords hospitalRecords;														//入院记录
	private DiseaseDevelopHistory	diseaseDevelopHistory;							//病程记录
	private SurgeryConsent	surgeryConsent;													//手术同意书
	private AnesthesiaConsent	anesthesiaConsent;											//麻醉同意书
	private BloodTransfusionConsent	bloodTransfusionConsent;			//输血同意书
	private SpecialTreatmentConsent  	specialTreatmentConsent;			//特殊治疗通知书
	private DeathDangerousNotice			deathDangerousNotice;					//病危通知书
	private DocterAdvice								docterAdvice;										//医嘱（长期医嘱单和临时医嘱）
	
	private AssistExamination					assistExamination;							//辅助检查报告
	private NurseReport								nurseReport;										//保温单
	
	
	
	
}
