package com.hengyun.domain.system;

import java.io.Serializable;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月9日 下午5:13:05
* 版本更新返回值
*/
public class AppVersionUpdateResponse extends ResponseCode implements Serializable{

	private AppVersionUpdate version;

	public AppVersionUpdate getVersion() {
		return version;
	}

	public void setVersion(AppVersionUpdate version) {
		this.version = version;
	}				
	
	
	
	
}
