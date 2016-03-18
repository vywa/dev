package com.hengyun.domain.casehistory.response;

import java.io.Serializable;

import com.hengyun.domain.casehistory.Diagnosis;
import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月18日 下午3:25:21
* 诊断类返回值
*/
public class DiagnosisResponse extends ResponseCode implements Serializable{
	private Diagnosis diagnosis;								//诊断类

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}
	
}
