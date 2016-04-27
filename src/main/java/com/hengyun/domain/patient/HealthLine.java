package com.hengyun.domain.patient;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月27日 上午10:56:48
* 健康参考线
*/
public class HealthLine implements Serializable{

	private int userId;
	
	private int highBPValue;
	private int lowBPValue;
	
	private double minValue;
	private double maxBeforeMealValue;
	private double maxAfterMealValue;
	
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getHighBPValue() {
		return highBPValue;
	}

	public void setHighBPValue(int highBPValue) {
		this.highBPValue = highBPValue;
	}

	public int getLowBPValue() {
		return lowBPValue;
	}

	public void setLowBPValue(int lowBPValue) {
		this.lowBPValue = lowBPValue;
	}

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public double getMaxBeforeMealValue() {
		return maxBeforeMealValue;
	}

	public void setMaxBeforeMealValue(double maxBeforeMealValue) {
		this.maxBeforeMealValue = maxBeforeMealValue;
	}

	public double getMaxAfterMealValue() {
		return maxAfterMealValue;
	}

	public void setMaxAfterMealValue(double maxAfterMealValue) {
		this.maxAfterMealValue = maxAfterMealValue;
	}

	public HealthLine() {
		super();
		this.highBPValue = 140;
		this.lowBPValue = 90;
		this.minValue = 3.9;
		this.maxBeforeMealValue = 7;
		this.maxAfterMealValue = 11.1;
		// TODO Auto-generated constructor stub
	}


	
}
