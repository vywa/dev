package com.hengyun.domain.information;

import java.io.Serializable;

import com.hengyun.domain.common.BaseResponseCode;

/*
 * 
 *  信息返回
 * */
public class UploadImageResponse extends BaseResponseCode implements Serializable{

	private String iconUrl;
	private long recordTime;
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public long getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(long recordTime) {
		this.recordTime = recordTime;
	}
	
	
	
	
}
