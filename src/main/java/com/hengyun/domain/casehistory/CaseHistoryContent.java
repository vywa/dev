package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.Date;

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

public class CaseHistoryContent implements Serializable{

	private Date treatTime;					//就诊时间
	private int  officeId;			//科室信息
	private String chiefComplaint;								//主诉
	private String presentDiseaseHistory;		//现病史
	private String		pastDiseaseHistory;					//既病史
	private String			positiveSigns;										//阳性体征
	private String		negativeSigns;									//	阴性体征
	private String	assistExamination;						//辅助检查结果
	private String		diagnosisResult;							//诊断
	private String					docterAdvice;										//治疗意见
	
	private String 						docterName;										//医生签名

	public Date getTreatTime() {
		return treatTime;
	}

	public void setTreatTime(Date treatTime) {
		this.treatTime = treatTime;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public String getPresentDiseaseHistory() {
		return presentDiseaseHistory;
	}

	public void setPresentDiseaseHistory(String presentDiseaseHistory) {
		this.presentDiseaseHistory = presentDiseaseHistory;
	}

	public String getPastDiseaseHistory() {
		return pastDiseaseHistory;
	}

	public void setPastDiseaseHistory(String pastDiseaseHistory) {
		this.pastDiseaseHistory = pastDiseaseHistory;
	}

	public String getPositiveSigns() {
		return positiveSigns;
	}

	public void setPositiveSigns(String positiveSigns) {
		this.positiveSigns = positiveSigns;
	}

	public String getNegativeSigns() {
		return negativeSigns;
	}

	public void setNegativeSigns(String negativeSigns) {
		this.negativeSigns = negativeSigns;
	}

	public String getAssistExamination() {
		return assistExamination;
	}

	public void setAssistExamination(String assistExamination) {
		this.assistExamination = assistExamination;
	}

	public String getDiagnosisResult() {
		return diagnosisResult;
	}

	public void setDiagnosisResult(String diagnosisResult) {
		this.diagnosisResult = diagnosisResult;
	}

	public String getDocterAdvice() {
		return docterAdvice;
	}

	public void setDocterAdvice(String docterAdvice) {
		this.docterAdvice = docterAdvice;
	}

	public String getDocterName() {
		return docterName;
	}

	public void setDocterName(String docterName) {
		this.docterName = docterName;
	}
	
	
	
}
