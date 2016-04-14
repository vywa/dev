package com.hengyun.service.impl.information;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.information.PatientInformationDao;
import com.hengyun.domain.account.PatientInfo;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.information.PatientInformationService;
import com.mongodb.gridfs.GridFSDBFile;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午4:33:18
* 类说明
*/
public class PatientInformationServiceImpl extends BaseServiceImpl<PatientInfo,Integer> implements PatientInformationService{

	private static final Logger log = LoggerFactory.getLogger(PatientInformationServiceImpl.class);
	
	@Resource
	private PatientInformationDao patientInformationDao;
	
	@Override
	public PatientInfo query(int userId) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public int update(PatientInfo patientInfo) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("patientId").is(patientInfo.getPatientId()));
		String birthday = patientInfo.getBirthday();
		
		int age = -1;
		Date date2=null;
			try {
			//	String digital = birthday.replaceAll("年", ".").replaceAll("月", ".").replaceAll("日", "");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日"); 
				date2=new Date();
				date2 = simpleDateFormat.parse(birthday);
				age = new Date().getYear()-date2.getYear();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (NullPointerException e) {
				// TODO Auto-generated catch block
				log.info("用户未设置生日");
			}
	
		Update update = Update.update("address",patientInfo.getAddress()).set("height", patientInfo.getHeight()).
				set("weight", patientInfo.getWeight()).set("sex",patientInfo.getSex()).
				set("birthday", patientInfo.getBirthday()).set("age",age).set("nation", patientInfo.getNation()).
				set("trueName", patientInfo.getTrueName()).
				set("recordTime",String.valueOf(new Date().getTime()));
		
		patientInformationDao.updateFirst(query, update);
	
		return 0;
	}

	@Override
	public void save(InputStream in, String filename) {
		// TODO Auto-generated method stub
		patientInformationDao.save(in, filename);
	
	}

	@Override
	public GridFSDBFile retrieveFileOne(String filename) {
		// TODO Auto-generated method stub
		return patientInformationDao.retrieveFileOne(filename);
	}

}
