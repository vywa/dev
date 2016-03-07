package com.hengyun.domain.casehistory;

import java.io.Serializable;

/*
 *  家族病史
 *  父母、兄弟、姐妹健康状况，有无与患者类似疾病，有无家族遗传倾向的疾病。
 * 
 * */
public class FamiliyHistory implements Serializable{

	private String inherit;

	public String getInherit() {
		return inherit;
	}

	public void setInherit(String inherit) {
		this.inherit = inherit;
	}
	
	
	
}
