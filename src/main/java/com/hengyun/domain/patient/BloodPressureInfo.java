package com.hengyun.domain.patient;

import java.util.Date;

/*
 *  
 *  血压信息
 * */

public class BloodPressureInfo {

	private int id;										//病人id
	private String name;							//病人姓名
	private Date examTime;					//测量时间
	private double examDate;				//测量数据
	private String examResult;				//测量结论（太低，低，微低，正常，微高，高，超高）
	private String examStatus;				//测量状态
	
	
}
