package com.hengyun.domain.information;

import java.io.Serializable;

import com.hengyun.domain.common.BaseResponseCode;

public class NickIconResponse extends BaseResponseCode implements Serializable{

	private NickIcon nickIcon;

	public NickIcon getNickIcon() {
		return nickIcon;
	}

	public void setNickIcon(NickIcon nickIcon) {
		this.nickIcon = nickIcon;
	}			
	
}
