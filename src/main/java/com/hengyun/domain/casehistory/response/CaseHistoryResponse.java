package com.hengyun.domain.casehistory.response;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.casehistory.CaseHistory;
import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月18日 下午3:05:49
* 病历返回类
*/
public class CaseHistoryResponse extends ResponseCode implements Serializable{

	private List<CaseHistory> caseHistoryList;							//病历类

	public List<CaseHistory> getCaseHistoryList() {
		return caseHistoryList;
	}

	public void setCaseHistoryList(List<CaseHistory> caseHistoryList) {
		this.caseHistoryList = caseHistoryList;
	}

	
	
	
}
