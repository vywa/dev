package com.hengyun.domain.casehistory;

import java.io.Serializable;

/*
 * 体格检查
 * 内容包括体温、脉搏、呼吸、血压，一般情况，皮肤、粘膜，全身浅表淋巴结，
 * 头部及其器官，颈部，胸部(胸廓、肺部、心脏、血管)，腹部(肝、脾等)，
 * 直肠肛门，外生殖器，脊柱，四肢，神经系统等。
 * */
public class PhysicalExamination implements Serializable{

	private double temperature;
	private int heatBeat;
	private int breath;
	private int bloodPrussure;
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public int getHeatBeat() {
		return heatBeat;
	}
	public void setHeatBeat(int heatBeat) {
		this.heatBeat = heatBeat;
	}
	public int getBreath() {
		return breath;
	}
	public void setBreath(int breath) {
		this.breath = breath;
	}
	public int getBloodPrussure() {
		return bloodPrussure;
	}
	public void setBloodPrussure(int bloodPrussure) {
		this.bloodPrussure = bloodPrussure;
	}
	
	
}
