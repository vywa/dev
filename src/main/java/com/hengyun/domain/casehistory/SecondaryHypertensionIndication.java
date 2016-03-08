package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月8日 上午10:44:48
*继发高血压指征
*/
public class SecondaryHypertensionIndication implements Serializable{

	private int caseHistoryId;													//病历id
	
	private boolean renalParenchyma;								//	肾实质性
	private boolean primaryAldosteroneSyndrome;		//原发性醛固酮增多症
	private boolean sleepApneaSyndrome;							//睡眠呼吸暂停综合征
	private boolean cellTumor;													//嗜络细胞瘤
	private boolean kidneyVessel;												//肾血管病
	private boolean cushingSyndrome;									//库欣综合征
	
	private boolean drugInducedHypertesion;					//药源性高血压
	private String instruction;														//描述
	
	
	public int getCaseHistoryId() {
		return caseHistoryId;
	}
	public void setCaseHistoryId(int caseHistoryId) {
		this.caseHistoryId = caseHistoryId;
	}
	public boolean isRenalParenchyma() {
		return renalParenchyma;
	}
	public void setRenalParenchyma(boolean renalParenchyma) {
		this.renalParenchyma = renalParenchyma;
	}
	public boolean isPrimaryAldosteroneSyndrome() {
		return primaryAldosteroneSyndrome;
	}
	public void setPrimaryAldosteroneSyndrome(boolean primaryAldosteroneSyndrome) {
		this.primaryAldosteroneSyndrome = primaryAldosteroneSyndrome;
	}
	public boolean isSleepApneaSyndrome() {
		return sleepApneaSyndrome;
	}
	public void setSleepApneaSyndrome(boolean sleepApneaSyndrome) {
		this.sleepApneaSyndrome = sleepApneaSyndrome;
	}
	public boolean isCellTumor() {
		return cellTumor;
	}
	public void setCellTumor(boolean cellTumor) {
		this.cellTumor = cellTumor;
	}
	public boolean isKidneyVessel() {
		return kidneyVessel;
	}
	public void setKidneyVessel(boolean kidneyVessel) {
		this.kidneyVessel = kidneyVessel;
	}
	public boolean isCushingSyndrome() {
		return cushingSyndrome;
	}
	public void setCushingSyndrome(boolean cushingSyndrome) {
		this.cushingSyndrome = cushingSyndrome;
	}
	public boolean isDrugInducedHypertesion() {
		return drugInducedHypertesion;
	}
	public void setDrugInducedHypertesion(boolean drugInducedHypertesion) {
		this.drugInducedHypertesion = drugInducedHypertesion;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
	
}
