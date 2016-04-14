package com.hengyun.service.information;

import java.io.InputStream;

import com.hengyun.domain.account.PatientInfo;
import com.hengyun.service.BaseService;
import com.mongodb.gridfs.GridFSDBFile;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午4:25:25
* 类说明
*/
public interface PatientInformationService  extends BaseService<PatientInfo,Integer>{

	public PatientInfo query(int userId);
	
	public int update(PatientInfo patientInfo) ;
	
	  public void save(InputStream in,String filename);
	  
	  public GridFSDBFile retrieveFileOne(String filename);
	  
}
