package com.hengyun.service.impl.account;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.account.PatientAccountDao;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.domain.account.PatientInfo;
import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.service.account.PatientAccountService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.util.randomcode.EncryptPassword;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月5日 下午2:54:36
* 病人信息业务类
*/
public class PatientAccountServiceImpl extends BaseServiceImpl<PatientInfo,Integer> implements PatientAccountService{

	@Resource
	private PatientAccountDao patientAccountDao;
	
	@Resource
	private IndexCollectionDao indexCollectionDao;
	
	/*
	 *  获取病人信息
	 * */
	@Override
	public PatientInfo getPatientInfoById(int id) {
		// TODO Auto-generated method stub
		BasicDBObject condition = new BasicDBObject();
		condition.put("patientId", id);
		BasicDBObject fields = new BasicDBObject();
		fields.put("patientId", 1);
		fields.put("password", 1);
		fields.put("_id",0);
		Query query = new BasicQuery(condition,fields);
		PatientInfo info = patientAccountDao.queryOne(query);
		return info;
		
	}

	/*
	 *  病人账号是否存在
	 * */
	@Override
	public int existPatient(String sign, String type)  {
		// TODO Auto-generated method stub
		DBObject queryCondition=null;
		BasicDBObject fields = new BasicDBObject();
		fields.put("patientId", 1);
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
			break;
		case "QQ":
			  queryCondition = new BasicDBObject();
		       queryCondition.put("QQ", sign);
		       queryCondition.put("QQ", new BasicDBObject("$exists", true));
		       query = new BasicQuery(queryCondition,fields);
			break;
		case "weiChat":
			  queryCondition = new BasicDBObject();
		       queryCondition.put("weiChat", sign);
		       queryCondition.put("weiChat", new BasicDBObject("$exists", true));
		       query = new BasicQuery(queryCondition,fields);
			break;
		case "weiBo":
			  queryCondition = new BasicDBObject();
		       queryCondition.put("weiBo", sign);
		       queryCondition.put("weiBo", new BasicDBObject("$exists", true));
		       query = new BasicQuery(queryCondition,fields);
			break;
		default:break;
		
		}
		PatientInfo info = patientAccountDao.queryOne(query);
		if(info !=null){
			return info.getPatientId();	
		} else {
			return -1;
		}
		
	}

	
	/*
	 *  查询所有病人信息
	 * */
	@Override
	public List<PatientInfo> getUserAccountALL() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("patientId").exists(true));
		List<PatientInfo> plist = patientAccountDao.queryList(query);
		return plist;
	}

	/*
	 *  更改密码
	 * */
	@Override
	public void updatePassword(String password, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("patientId").is(userId));
		String enpassword = EncryptPassword.encode(password);
		Update update = Update.update("encrptPassword", enpassword);
		
		patientAccountDao.updateFirst(query, update);
		 
	}

	/*
	 *  注册病人
	 * */
	@Override
	public int registerPatient(String username,String type,String password) {
		// TODO Auto-generated method stub
		int patientId = indexCollectionDao.updateIndex("patientID");
		PatientInfo info = new PatientInfo();
		String enpassword=EncryptPassword.encode(password);
		info.setPassword(enpassword);
	
		switch(type){
		case "mobilephone":
			info.setMobilephone(username);
			break;
		case "email":
			info.setMobilephone(username);
			break;
		
		}
		info.setPatientId(patientId);
		patientAccountDao.save(info);
		return patientId;
	}

	/*
	 *  修改用户账号信息
	 * */
	
	@Override
	public int change(String type, String username, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("patientId").is(userId));
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
		case "QQ":
			 update = Update.update("QQ", username);
			break;
		case "weiChat":
			 update = Update.update("weiChat", username);
			break;
		case "weiBo":
			 update = Update.update("weiBo", username);
			break;
		default:
			break;
		}
		patientAccountDao.updateFirst(query, update);
		return 0;
	}

	/*
	 *  三方注册病人
	 * */
	
	@Override
	public int registerThirdAccount(String sign,String type){
		// TODO Auto-generated method stub
		int patientId = indexCollectionDao.updateIndex("patientID");
		PatientInfo info = new PatientInfo();
		switch(type){
		case "QQ":
			info.setQQ(sign);
			break;
		case "weiChat":
			info.setWeiChat(sign);
			break;
		case "weiBo":
			info.setWeiBo(sign);
			break;
		default:break;
		}
		info.setPatientId(patientId);
		patientAccountDao.save(info);
		return patientId;
	
	}

	
	/*
	 *  验证用户名密码是否正确
	 * */
	
	@Override
	public LoginResult validateUserBySign(String sign, String type, String password) {
		// TODO Auto-generated method stub
		BasicDBObject fields = new BasicDBObject();
		BasicDBObject condition = new BasicDBObject();
		fields.put("patientId", 1);
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
		default:break;
		}
		PatientInfo info = patientAccountDao.queryOne(query);
		if(info==null){ //账号不存在
			loginResult.setUserCode(-2);   //账号不存在
		} else {			//用户存在
			int status = info.getStatus();
			switch(status){
			case 0:	//账号状态正常
				String enpassword = info.getPassword();
				String test = EncryptPassword.encode(password);
				if(test.equals(enpassword)){
					loginResult.setUserId(info.getPatientId());		//登陆成功
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
