package com.hengyun.domain.friendcircle;

import java.util.ArrayList;
import java.util.List;

import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.information.Information;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月11日 下午1:58:29
* 好友列表信息
*/
public class RosterResponse extends ResponseCode{

	private List<Information> infos = new ArrayList<Information>();

	public List<Information> getInfos() {
		return infos;
	}

	public void setInfos(List<Information> infos) {
		this.infos = infos;
	}


}
