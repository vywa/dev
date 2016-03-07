package com.hengyun.domain.casehistory;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月7日 下午5:16:38
* 仪器检查
*/
public class MachineExamination implements Serializable{

	private String chestXRay;
	
	private String cardiogram;

	public String getChestXRay() {
		return chestXRay;
	}

	public void setChestXRay(String chestXRay) {
		this.chestXRay = chestXRay;
	}

	public String getCardiogram() {
		return cardiogram;
	}

	public void setCardiogram(String cardiogram) {
		this.cardiogram = cardiogram;
	}
	
	
}
