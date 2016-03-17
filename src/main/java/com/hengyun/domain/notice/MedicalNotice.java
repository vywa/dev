package com.hengyun.domain.notice;

import java.io.Serializable;

import com.hengyun.domain.casehistory.Diagnosis.DangerLevel;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月15日 下午4:18:34
* 医疗诊断危险通知
*/
public class MedicalNotice extends Notice implements Serializable{

	private int noticeType;											//通知类型
	private DangerLevel dangerLevel;									//危险等级


	public int getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(int noticeType) {
		this.noticeType = noticeType;
	}

	public DangerLevel getDangerLevel() {
		return dangerLevel;
	}

	public void setDangerLevel(DangerLevel dangerLevel) {
		this.dangerLevel = dangerLevel;
	}
	
	
	
}
