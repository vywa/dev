package com.hengyun.domain.casehistory.response;

import java.io.Serializable;

import com.hengyun.domain.casehistory.CaseHistory;
import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月5日 上午10:58:05
* 类说明
*/
public class CaseHistoryResponseCode extends ResponseCode implements Serializable{

	private CaseHistory caseHistory;							//病历类

	public CaseHistory getCaseHistory() {
		return caseHistory;
	}

	public void setCaseHistory(CaseHistory caseHistory) {
		this.caseHistory = caseHistory;
	}
	
	
}
