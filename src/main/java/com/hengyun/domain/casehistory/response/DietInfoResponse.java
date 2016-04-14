package com.hengyun.domain.casehistory.response;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.casehistory.DietInfo;
import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午2:52:34
* 类说明
*/
public class DietInfoResponse extends ResponseCode implements Serializable{

	private List<DietInfo> dietInfoList;

	public List<DietInfo> getDietInfoList() {
		return dietInfoList;
	}

	public void setDietInfoList(List<DietInfo> dietInfoList) {
		this.dietInfoList = dietInfoList;
	}
	
	
}
