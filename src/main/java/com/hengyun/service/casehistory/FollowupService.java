package com.hengyun.service.casehistory;

import java.util.List;

import com.hengyun.domain.casehistory.Followup;
import com.hengyun.service.BaseService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月21日 下午2:45:58
* 随访业务访问层
*/
public interface FollowupService extends BaseService<Followup,Integer>{

	public void addFollow(Followup followup);
	
	public Followup queryPatient(int patientId);
	
	public List<Followup> queryPList(int patientId);
	
	
	
}
