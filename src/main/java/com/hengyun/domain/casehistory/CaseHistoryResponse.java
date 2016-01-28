package com.hengyun.domain.casehistory;

import java.util.List;

import com.hengyun.domain.common.BaseResponseCode;

public class CaseHistoryResponse extends BaseResponseCode{

	private List<CaseHistory> list ;

	public List<CaseHistory> getList() {
		return list;
	}

	public void setList(List<CaseHistory> list) {
		this.list = list;
	}
	
	
}
