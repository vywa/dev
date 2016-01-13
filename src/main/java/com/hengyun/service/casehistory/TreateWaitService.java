package com.hengyun.service.casehistory;

import java.util.List;

import com.hengyun.domain.casehistory.TreateWait;
import com.hengyun.service.BaseService;


public interface TreateWaitService  extends BaseService<TreateWait,Integer> {

	public List<TreateWait> queryAll();
	
	
}
