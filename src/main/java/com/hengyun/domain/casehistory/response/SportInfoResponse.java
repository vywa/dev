package com.hengyun.domain.casehistory.response;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.casehistory.SportInfo;
import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午2:52:23
* 类说明
*/

public class SportInfoResponse extends ResponseCode implements Serializable{

	private List<SportInfo> sportList;

	public List<SportInfo> getSportList() {
		return sportList;
	}

	public void setSportList(List<SportInfo> sportList) {
		this.sportList = sportList;
	}

}
