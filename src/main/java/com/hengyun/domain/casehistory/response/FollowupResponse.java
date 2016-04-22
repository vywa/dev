package com.hengyun.domain.casehistory.response;

import java.io.Serializable;
import java.util.List;

import com.hengyun.domain.casehistory.Followup;
import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月21日 下午3:23:21
* 类说明
*/
public class FollowupResponse extends ResponseCode implements Serializable{

	private List<Followup> followupList;

	public List<Followup> getFollowupList() {
		return followupList;
	}

	public void setFollowupList(List<Followup> followupList) {
		this.followupList = followupList;
	}

	
	
}
