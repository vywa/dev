package com.hengyun.service.impl.hospital;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.hengyun.dao.hospital.DocterDao;
import com.hengyun.domain.hospital.Docter;
import com.hengyun.domain.hospital.Hospital;
import com.hengyun.domain.information.Information;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.hospital.DocterService;
import com.hengyun.service.hospital.HospitalService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.UserAccountService;

/*
 *  　医生信息管理
 * */

public class DocterServiceImpl extends BaseServiceImpl<Docter,Integer> implements DocterService{

	private static final Logger log = LoggerFactory.getLogger(DocterServiceImpl.class);
	@Resource 
	private DocterDao docterDao;

	@Resource
	private UserAccountService userAccountService;
	
	@Resource
	private InformationService informationService;
	
	@Resource
	private HospitalService hospitalService;
	
	public List<Docter> queryAll() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("workNum").exists(true));
		return docterDao.queryList(query);
		
	}

	//判断医生工号是否在录入数据库
	@Override
	public boolean exist(String workNum) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("workNum").is(workNum));
		
		try {
			Docter docter = docterDao.queryOne(query);
			if(docter!=null){
			return true;
			}
		} catch (NullPointerException ex) {
			// TODO Auto-generated catch block
			return false;
		}
		return false;
	}

	/*
	 * 	查询某个医院的医生
	 * */
	@Override
	public List<Docter> queryByHospital(int hospitalId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("hospitalId").is(hospitalId));
		Query query3 = Query.query(Criteria.where("id").is(hospitalId));
		Hospital hospital = hospitalService.queryOne(query3);
		List<Docter> docterList = docterDao.queryList(query);
		List<Docter> users =new ArrayList<Docter>();
		for(Docter temp : docterList){
			String workNum = temp.getWorkNum();
			Query query2= Query.query(Criteria.where("workNum").is(workNum));
			UserAccount account = userAccountService.queryOne(query2);
			int userId = account.getId();
			String birthday = null;
			Date date2 =null;
			int	age=-1;
			Information info = informationService.query(userId);
			try {
				birthday = info.getBirthday();
				String digital = birthday.replaceAll("年", ".").replaceAll("月", ".").replaceAll("日", "");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd"); 
				date2=new Date();
				date2 = simpleDateFormat.parse(digital);
				age = new Date().getYear()-date2.getYear();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				log.info("该用户没有设置生日，年龄未知");
			}catch (NullPointerException e) {
				// TODO Auto-generated catch block
				log.info("该用户没有设置生日，年龄未知");
			}
				
			
			Docter doctor = new Docter();
			doctor.setAge(age);
			doctor.setImage(info.getIconUrl());
			doctor.setName(info.getTrueName());
			doctor.setResume(info.getResume());
			doctor.setSex(info.getSex());
			doctor.setShortName(hospital.getShortName());
			doctor.setUserId(userId);
			users.add(doctor);
		}
		
		return users;
	}
	

}
