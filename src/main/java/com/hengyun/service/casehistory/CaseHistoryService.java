package com.hengyun.service.casehistory;

import java.util.List;

import com.hengyun.domain.casehistory.CaseHistory;
import com.hengyun.service.BaseService;


public interface CaseHistoryService  extends BaseService<CaseHistory,Integer> {

	public CaseHistory query(int caseHistoryId);
	public List<CaseHistory> queryAll();
	
	public int addCaseHistory(CaseHistory caseHistory);
	
	//根据病历病人id
	public int getPatientId(int caseHistoryId);
	
	//根据病历查找医生id
	public int getDoctorId(int caseHistoryId);
	
	
	
}
