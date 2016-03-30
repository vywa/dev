package com.hengyun.domain.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月30日 上午11:07:59
* app返回类
*/
public class AppPackageResponse extends ResponseCode{

	private List<AppPackage> list = new ArrayList<AppPackage>();

	public List<AppPackage> getList() {
		return list;
	}

	public void setList(List<AppPackage> list) {
		this.list = list;
	}
	
	
	
	
}
