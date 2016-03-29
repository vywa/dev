package com.hengyun.domain.information;

import java.util.ArrayList;
import java.util.List;

import com.hengyun.domain.common.ResponseCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月29日 下午2:56:49
* 收藏返回类
*/
public class CollectionResponse extends ResponseCode{

	private List<Collection> collectionList = new ArrayList<Collection>();

	public List<Collection> getCollectionList() {
		return collectionList;
	}

	public void setCollectionList(List<Collection> collectionList) {
		this.collectionList = collectionList;
	}
	
	
}
