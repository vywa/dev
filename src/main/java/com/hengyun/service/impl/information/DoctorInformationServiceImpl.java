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

import com.hengyun.dao.information.DoctorInformationDao;
import com.hengyun.domain.account.DoctorInfo;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.information.DoctorInformationService;
import com.mongodb.gridfs.GridFSDBFile;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月14日 下午4:33:49
* 类说明
*/
public class DoctorInformationServiceImpl extends BaseServiceImpl<DoctorInfo,Integer> implements DoctorInformationService{

	private static final Logger log = LoggerFactory.getLogger(DoctorInformationServiceImpl.class);
	
	@Resource
	private DoctorInformationDao doctorInformationDao;
	

	@Override
	public DoctorInfo query(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(DoctorInfo doctorInfo) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("doctorId").is(doctorInfo.getDoctorId()));
		String birthday = doctorInfo.getBirthday();
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
	
		Update update = Update.update("address",doctorInfo.getAddress()).set("sex",doctorInfo.getSex()).
				set("birthday", doctorInfo.getBirthday()).set("age",age).set("nation", doctorInfo.getNation()).
				set("trueName", doctorInfo.getTrueName()).set("resume", doctorInfo.getResume()).
				set("recordTime",String.valueOf(new Date().getTime()));
		
		doctorInformationDao.updateFirst(query, update);
	
		return 0;
	}

	@Override
	public void save(InputStream in, String filename) {
		// TODO Auto-generated method stub
		doctorInformationDao.save(in, filename);
	}

	@Override
	public GridFSDBFile retrieveFileOne(String filename) {
		// TODO Auto-generated method stub
		return doctorInformationDao.retrieveFileOne(filename);
	}

}
