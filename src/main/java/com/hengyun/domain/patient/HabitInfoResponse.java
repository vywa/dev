package com.hengyun.domain.patient;

import com.hengyun.domain.casehistory.HabitInfo;
import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月1日 下午4:58:47
* 健康习惯响应类
*/
public class HabitInfoResponse extends ResponseCode{

	private HabitInfo habitInfo;

	public HabitInfo getHabitInfo() {
		return habitInfo;
	}

	public void setHabitInfo(HabitInfo habitInfo) {
		this.habitInfo = habitInfo;
	}
	
	
}
