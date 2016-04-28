package com.hengyun.domain.notice;

import java.util.ArrayList;
import java.util.List;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月30日 下午4:20:42
* 类说明
*/
public class DailyNewsListResponse extends ResponseCode{

	private List<DailyNewsResponseList> daily = new ArrayList<DailyNewsResponseList>();

	public List<DailyNewsResponseList> getDaily() {
		return daily;
	}

	public void setDaily(List<DailyNewsResponseList> daily) {
		this.daily = daily;
	}
	
}
