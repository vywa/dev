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

import com.hengyun.dao.information.InformationDao;
import com.hengyun.domain.information.Information;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;
import com.mongodb.gridfs.GridFSDBFile;

/*
 *  　个人信息管理
 * */

public class InformationServiceImpl extends BaseServiceImpl<Information,Integer> implements InformationService{

	 private static final Logger log = LoggerFactory.getLogger(InformationServiceImpl.class);
	@Resource 
	private InformationDao informationDao;
	@Resource
	
	private LoginInfoService loginInfoService;
	
	//添加资料
	public int add(Information generalInfo,int userId) {
		// TODO Auto-generated method stub
	
			generalInfo.setUserId(userId);
			 String fileUrl = "http://192.168.31.114/healthcloudserver/info/download?iconUrl=200000010temp.jpg";
			generalInfo.setIconUrl(fileUrl);
			generalInfo.setRecordTime(String.valueOf(new Date().getTime()));
			informationDao.save(generalInfo);
			log.info("用户: "+userId +"基本资料保存成功");
			return userId;

	}
	
	//保存文件
	public void save(InputStream in, String filename) {
		// TODO Auto-generated method stub
		this.save(in, filename);
	}
	
	//下载文件
	public GridFSDBFile retrieveFileOne(String filename) {
		// TODO Auto-generated method stub
		return this.retrieveFileOne(filename);
	}

	public Information query(int userId) {
		// TODO Auto-generated method stub
	
			Query query = Query.query(Criteria.where("userId").is(userId));
			Information information = informationDao.queryOne(query);
			if(information!=null){
			return information;
			}
			else 
				return null;
		
	}

	//更新资料
	public int update(Information information, int userId) {
		// TODO Auto-generated method stub
	
			Query query = Query.query(Criteria.where("userId").is(userId));
			String birthday = information.getBirthday();
		
			Date date2=null;
				try {
					String digital = birthday.replaceAll("年", ".").replaceAll("月", ".").replaceAll("日", "");
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd"); 
					date2=new Date();
					date2 = simpleDateFormat.parse(digital);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (NullPointerException e) {
					// TODO Auto-generated catch block
					 date2=new Date();
				}
				int	age = new Date().getYear()-date2.getYear();
			Update update = Update.update("address",information.getAddress()).set("height", information.getHeight()).
					set("weight", information.getWeight()).set("sex",information.getSex()).
					set("birthday", information.getBirthday()).set("age",age).
					set("trueName", information.getTrueName()).
					set("recordTime",String.valueOf(new Date().getTime()));
			informationDao.updateFirst(query, update);
			log.info("用户 "+userId+" 资料修改成功");
			return userId;
	
	}

}
