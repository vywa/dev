package com.hengyun.service.impl.account;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.account.DoctorAccountDao;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.domain.account.DoctorInfo;
import com.hengyun.domain.account.PatientInfo;
import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.service.account.DoctorAccountService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.util.randomcode.EncryptPassword;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月5日 下午2:54:18
* 医生信息业务类
*/
public class DoctorAccountServiceImpl  extends BaseServiceImpl<DoctorInfo,Integer> implements DoctorAccountService{

	@Resource
	private DoctorAccountDao doctorAccountDao;
	
	@Resource
	private IndexCollectionDao indexCollectionDao;
	
	/*
	 *  查询医生账号信息
	 * */
	@Override
	public DoctorInfo getDoctorInfoById(int id) {
		// TODO Auto-generated method stub
		BasicDBObject condition = new BasicDBObject();
		condition.put("doctorId", id);
		BasicDBObject fields = new BasicDBObject();
		fields.put("doctorId", 1);
		fields.put("password", 1);
		fields.put("_id",0);
		Query query = new BasicQuery(condition,fields);
		DoctorInfo info = doctorAccountDao.queryOne(query);
		return info;
	}

	/*
	 *  医生是否存在
	 * */
	@Override
	public int existDoctor(String sign, String type) {
		// TODO Auto-generated method stub
		DBObject queryCondition=null;
		BasicDBObject fields = new BasicDBObject();
		fields.put("doctorId", 1);
		fields.put("_id", 0);
		Query query=null ;
		switch(type){
		case "username":
			  queryCondition = new BasicDBObject();
		       queryCondition.put("username", sign);
		       queryCondition.put("username", new BasicDBObject("$exists", true));
		       query = new BasicQuery(queryCondition,fields);
			break;
		case "mobilephone":
			  queryCondition = new BasicDBObject();
		       queryCondition.put("mobilephone", sign);
		       queryCondition.put("mobilephone", new BasicDBObject("$exists", true));
		       query = new BasicQuery(queryCondition,fields);
			break;
		case "email":
			  queryCondition = new BasicDBObject();
		       queryCondition.put("email", sign);
		       queryCondition.put("email", new BasicDBObject("$exists", true));
		       query = new BasicQuery(queryCondition,fields);
		case "workNum":
			  queryCondition = new BasicDBObject();
		       queryCondition.put("workNum", sign);
		       queryCondition.put("workNum", new BasicDBObject("$exists", true));
		       query = new BasicQuery(queryCondition,fields);
			break;
	
		default:break;
		
		}
		DoctorInfo info = doctorAccountDao.queryOne(query);
		if(info !=null){				//存在账号
			return info.getDoctorId();
		} else {
			return -1;
		}
	}

	/*
	 *  查询所有医生账号
	 * */
	@Override
	public List<DoctorInfo> getUserAccountALL() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("doctorId").exists(true));
		List<DoctorInfo> plist = doctorAccountDao.queryList(query);
		return plist;
	}

	/*
	 *  修改密码
	 * */
	@Override
	public void updatePassword(String password, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("doctorId").is(userId));
		String enpassword = EncryptPassword.encode(password);
		Update update = Update.update("encrptPassword", enpassword);
		
		doctorAccountDao.updateFirst(query, update);
	}

	@Override
	public int registerDoctor(String username,String type,String password) {
		// TODO Auto-generated method stub
		int doctorId = indexCollectionDao.updateIndex("docterID");
		DoctorInfo info = new DoctorInfo();
		String enpassword=EncryptPassword.encode(password);
		info.setPassword(enpassword);
	
		switch(type){
		case "mobilephone":
			info.setMobilephone(username);
			break;
		case "email":
			info.setMobilephone(username);
			break;
		case "workNum":
			info.setWorkNum(username);
			break;
			default:break;
		
		}
		info.setDoctorId(doctorId);
		doctorAccountDao.save(info);
		return doctorId;
	}

	/*
	 *  更改用户信息
	 * */
	@Override
	public int change(String type, String username, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("doctorId").is(userId));
		Update update = null;
		switch(type){
		case "mobilephone":
				 update = Update.update("mobilephone", username);
			break;
		case "email":
			 update = Update.update("email", username);
			break;
		case "username":
			 update = Update.update("username", username);
			break;
		case "workNum":
			 update = Update.update("workNum", username);
			break;
	
		default:
			break;
		}
		doctorAccountDao.updateFirst(query, update);
		return 0;
	}

	/*
	 *  登陆验证
	 * */
	@Override
	public LoginResult validateUserBySign(String sign, String type, String password) {
		// TODO Auto-generated method stub
		BasicDBObject fields = new BasicDBObject();
		BasicDBObject condition = new BasicDBObject();
		fields.put("doctorId", 1);
		fields.put("password", 1);
		fields.put("status", 1);
		fields.put("_id",0);
		Query query = null;
		LoginResult loginResult = new LoginResult();
		switch(type){
		case "username":
			 condition = new BasicDBObject();
			condition = new BasicDBObject();
			condition.put("username", sign);
			condition.put("username", new BasicDBObject("$exists", true));
		       query = new BasicQuery(condition,fields);
			break;
		case "mobilephone":
			 condition = new BasicDBObject();
			condition.put("mobilephone", sign);
			condition.put("mobilephone", new BasicDBObject("$exists", true));
		       query = new BasicQuery(condition,fields);
			break;
		case "email":
			 condition = new BasicDBObject();
				condition.put("email", sign);
				condition.put("email", new BasicDBObject("$exists", true));
			       query = new BasicQuery(condition,fields);
			break;
		case "workNum":
			 condition = new BasicDBObject();
				condition.put("workNum", sign);
				condition.put("workNum", new BasicDBObject("$exists", true));
			       query = new BasicQuery(condition,fields);
			break;
		default:break;
		}
		DoctorInfo info = doctorAccountDao.queryOne(query);
		if(info==null){ //账号不存在
			loginResult.setUserCode(-2);   //账号不存在
		} else {			//用户存在
			int status = info.getStatus();
			switch(status){
			case 0:	//账号状态正常
				String enpassword = info.getPassword();
				String test = EncryptPassword.encode(password);
				if(test.equals(enpassword)){
					loginResult.setUserId(info.getDoctorId());		//登陆成功
				} else {
					loginResult.setUserCode(-1); 		//用户密码错误
				}
				break;
				
			case 1:
				loginResult.setUserCode(-3); 		//账号异常
				break;
			case 2:
				loginResult.setUserCode(-4); 		//账号冻结
				break;
			case -1:
				loginResult.setUserCode(-5);       	//账号删除
				break;
			}
		}
		return loginResult;
	}

	
}
