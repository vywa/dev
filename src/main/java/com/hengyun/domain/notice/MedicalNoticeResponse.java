package com.hengyun.domain.notice;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月17日 上午11:37:23
* 医疗通知响应类
*/
public class MedicalNoticeResponse extends ResponseCode implements Serializable{

	private List<MedicalNotice> medicalNoticeList;							//医疗通知

	public List<MedicalNotice> getMedicalNoticeList() {
		return medicalNoticeList;
	}

	public void setMedicalNoticeList(List<MedicalNotice> medicalNoticeList) {
		this.medicalNoticeList = medicalNoticeList;
	}

}
