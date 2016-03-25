package com.hengyun.domain.monitor;

import java.util.ArrayList;
import java.util.List;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月25日 下午5:13:35
* 异常信息返回值
*/
public class ExceptionInfoResponse extends ResponseCode{

	private List<ExceptionInfo> exceptionInfoList = new ArrayList<ExceptionInfo>();

	public List<ExceptionInfo> getExceptionInfoList() {
		return exceptionInfoList;
	}

	public void setExceptionInfoList(List<ExceptionInfo> exceptionInfoList) {
		this.exceptionInfoList = exceptionInfoList;
	}
	
	
}
