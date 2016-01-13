package com.hengyun.service.casehistory;

import java.util.List;

import com.hengyun.domain.casehistory.ReTreateInfo;
import com.hengyun.service.BaseService;


public interface ReTreateInfoService  extends BaseService<ReTreateInfo,Integer> {

	public List<ReTreateInfo> queryAll();
	
	
}
