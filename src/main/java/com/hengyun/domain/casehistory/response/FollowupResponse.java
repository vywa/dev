package com.hengyun.domain.casehistory.response;

import java.io.Serializable;

import com.hengyun.domain.casehistory.Followup;
import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月21日 下午3:23:21
* 类说明
*/
public class FollowupResponse extends ResponseCode implements Serializable{

	private Followup followup;

	public Followup getFollowup() {
		return followup;
	}

	public void setFollowup(Followup followup) {
		this.followup = followup;
	}
	
	
}
