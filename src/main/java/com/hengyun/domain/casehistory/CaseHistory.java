package com.hengyun.domain.casehistory;

import java.io.Serializable;
import java.util.Date;


/*
 * 
 * 	病历基本信息，包括门诊病历首页，病历记录，化验单（检查报告），医学影像检查资料
 * 
 * */

public class CaseHistory implements Serializable{

	
	private int caseHistoryId;															//病历编号
	
	private int patientId;											//病人id
	
	private int docterId;												//医生id
	
	private Date diagnosisTime;								//初诊日期
	
	private PatientInfo patientInfo;						//病人的基本信息
	
	private HabitInfo habitInfo;								//生活方式
	
	private ChiefComplaint chiefComplaint;		//主诉
	
	private BloodPressure bloodPressure;			//血压
	
	private BloodSugger bloodSugger;					//血糖
	
	private Symptom symptom;								//症状
	
	private PastDiseaseHistory pastDiseaseHistory;		//既往史
	
	private String otherSymptom;							//其他症状
	
	private AllergyHistory allergyHistory;				//过敏史
	
	private FamilyHistory familyHistory;				//家族史
	
	private PhysicalExamination physicalExamination;				//体检
	
	private MentalState mentalState;					//心理状态
	
	private SecondaryHypertensionIndication shi;		//继发高血压指征
	
	private RiskFactor riskFactor;								//危险因素
	
	private TargetOrganDamage targetOrganDamage;				//靶器官损害
	
	private AffiliatedClinicalDisease affiliatedClinicalDisease;			//伴临床疾患
	
	private Diagnosis diagnosis;															//诊断
	
	private CurrentMedicine currentMedicine;								//目前用药
	
	private DoctorAdvice doctorAdvice;												//医嘱处方

	public int getCaseHistoryId() {
		return caseHistoryId;
	}

	public void setCaseHistoryId(int caseHistoryId) {
		this.caseHistoryId = caseHistoryId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDocterId() {
		return docterId;
	}

	public void setDocterId(int docterId) {
		this.docterId = docterId;
	}

	public Date getDiagnosisTime() {
		return diagnosisTime;
	}

	public void setDiagnosisTime(Date diagnosisTime) {
		this.diagnosisTime = diagnosisTime;
	}

	public PatientInfo getPatientInfo() {
		return patientInfo;
	}

	public void setPatientInfo(PatientInfo patientInfo) {
		this.patientInfo = patientInfo;
	}

	public HabitInfo getHabitInfo() {
		return habitInfo;
	}

	public void setHabitInfo(HabitInfo habitInfo) {
		this.habitInfo = habitInfo;
	}

	public ChiefComplaint getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(ChiefComplaint chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public BloodPressure getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(BloodPressure bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public BloodSugger getBloodSugger() {
		return bloodSugger;
	}

	public void setBloodSugger(BloodSugger bloodSugger) {
		this.bloodSugger = bloodSugger;
	}

	public Symptom getSymptom() {
		return symptom;
	}

	public void setSymptom(Symptom symptom) {
		this.symptom = symptom;
	}

	public PastDiseaseHistory getPastDiseaseHistory() {
		return pastDiseaseHistory;
	}

	public void setPastDiseaseHistory(PastDiseaseHistory pastDiseaseHistory) {
		this.pastDiseaseHistory = pastDiseaseHistory;
	}

	public String getOtherSymptom() {
		return otherSymptom;
	}

	public void setOtherSymptom(String otherSymptom) {
		this.otherSymptom = otherSymptom;
	}

	public AllergyHistory getAllergyHistory() {
		return allergyHistory;
	}

	public void setAllergyHistory(AllergyHistory allergyHistory) {
		this.allergyHistory = allergyHistory;
	}

	public FamilyHistory getFamilyHistory() {
		return familyHistory;
	}

	public void setFamilyHistory(FamilyHistory familyHistory) {
		this.familyHistory = familyHistory;
	}

	public PhysicalExamination getPhysicalExamination() {
		return physicalExamination;
	}

	public void setPhysicalExamination(PhysicalExamination physicalExamination) {
		this.physicalExamination = physicalExamination;
	}

	public MentalState getMentalState() {
		return mentalState;
	}

	public void setMentalState(MentalState mentalState) {
		this.mentalState = mentalState;
	}

	public SecondaryHypertensionIndication getShi() {
		return shi;
	}

	public void setShi(SecondaryHypertensionIndication shi) {
		this.shi = shi;
	}

	public RiskFactor getRiskFactor() {
		return riskFactor;
	}

	public void setRiskFactor(RiskFactor riskFactor) {
		this.riskFactor = riskFactor;
	}

	public TargetOrganDamage getTargetOrganDamage() {
		return targetOrganDamage;
	}

	public void setTargetOrganDamage(TargetOrganDamage targetOrganDamage) {
		this.targetOrganDamage = targetOrganDamage;
	}

	public AffiliatedClinicalDisease getAffiliatedClinicalDisease() {
		return affiliatedClinicalDisease;
	}

	public void setAffiliatedClinicalDisease(AffiliatedClinicalDisease affiliatedClinicalDisease) {
		this.affiliatedClinicalDisease = affiliatedClinicalDisease;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public CurrentMedicine getCurrentMedicine() {
		return currentMedicine;
	}

	public void setCurrentMedicine(CurrentMedicine currentMedicine) {
		this.currentMedicine = currentMedicine;
	}

	public DoctorAdvice getDoctorAdvice() {
		return doctorAdvice;
	}

	public void setDoctorAdvice(DoctorAdvice doctorAdvice) {
		this.doctorAdvice = doctorAdvice;
	}
	
	
	
}
