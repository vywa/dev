package com.hengyun.domain.patient;

import java.io.Serializable;
import java.util.Date;


/*
 * 	用户血压，血糖等健康数据
 * */
public class HealthDateInfo implements Serializable{

	private String ID;								//用户ID
	private BloodPressureInfo  bloodPressure;			//血压
	private BloodSuggerInfo		bloodSugger;				//血糖
	
}
