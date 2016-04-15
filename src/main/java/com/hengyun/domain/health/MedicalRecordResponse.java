package com.hengyun.domain.health;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月15日 上午11:08:01
* 类说明
*/
public class MedicalRecordResponse extends ResponseCode implements Serializable{

	private List<MedicalRecord> recordList ;

	public List<MedicalRecord> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<MedicalRecord> recordList) {
		this.recordList = recordList;
	}
	
	
	
}
