package com.hengyun.domain.patient;

import java.io.Serializable;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月27日 下午2:19:26
* 参考线响应
*/
public class HealthLineResponse extends ResponseCode implements Serializable{

	private HealthLine healthLine;

	public HealthLine getHealthLine() {
		return healthLine;
	}

	public void setHealthLine(HealthLine healthLine) {
		this.healthLine = healthLine;
	}
	
	
}
