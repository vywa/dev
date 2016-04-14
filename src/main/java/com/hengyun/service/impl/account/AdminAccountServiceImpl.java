package com.hengyun.service.impl.account;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.account.AdminAccountDao;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.domain.account.AdminInfo;
import com.hengyun.domain.account.DoctorInfo;
import com.hengyun.domain.loginInfo.LoginResult;
import com.hengyun.service.account.AdminAccountService;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.util.randomcode.EncryptPassword;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月13日 下午2:42:10
* 类说明
*/
public class AdminAccountServiceImpl extends BaseServiceImpl<AdminInfo,Integer> implements AdminAccountService{

	@Resource
	private AdminAccountDao adminAccountDao;
	
	@Resource
	private IndexCollectionDao indexCollectionDao;
	
	/*
	 *  是否存在管理员
	 * */
	@Override
	public int existAdmin(String sign, String type) {
		// TODO Auto-generated method stub
		DBObject queryCondition=null;
		BasicDBObject fields = new BasicDBObject();
		fields.put("adminId", 1);
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
		default:break;
		
		}
		AdminInfo info = adminAccountDao.queryOne(query);
		if(info !=null){				//存在账号
			return info.getAdminId();
		} else {
			return -1;
		}
	}
	
	/*
	 *  注册管理员账号
	 * */
	@Override
	public int registerAdmin(String username, String type, String password) {
		// TODO Auto-generated method stub
		int adminId = indexCollectionDao.updateIndex("adminID");
		AdminInfo info = new AdminInfo();
		String enpassword=EncryptPassword.encode(password);
		info.setPassword(enpassword);
	
		switch(type){
		case "mobilephone":
			info.setMobilephone(username);
			break;
		case "email":
			info.setMobilephone(username);
			break;
	
			default:break;
		
		}
		info.setAdminId(adminId);
		adminAccountDao.save(info);
		return adminId;
	}

	/*
	 *  登陆验证
	 * */
	@Override
	public LoginResult validateUserBySign(String sign, String type, String password) {
		// TODO Auto-generated method stub
		BasicDBObject fields = new BasicDBObject();
		BasicDBObject condition = new BasicDBObject();
		fields.put("adminId", 1);
		fields.put("password", 1);
		fields.put("status", 1);
		fields.put("_id",0);
		Query query = null;
		LoginResult loginResult = new LoginResult();
		switch(type){
		case "username":
			condition.put("username", sign);
			condition.put("username", new BasicDBObject("$exists", true));
		       query = new BasicQuery(condition,fields);
			break;
		case "mobilephone":
			condition.put("mobilephone", sign);
			condition.put("mobilephone", new BasicDBObject("$exists", true));
		       query = new BasicQuery(condition,fields);
			break;
		case "email":
				condition.put("email", sign);
				condition.put("email", new BasicDBObject("$exists", true));
			       query = new BasicQuery(condition,fields);
			break;
	
		default:break;
		}
		AdminInfo info = adminAccountDao.queryOne(query);
		if(info==null){ //账号不存在
			loginResult.setUserCode(-2);   //账号不存在
		} else {			//用户存在
			int status = info.getStatus();
			switch(status){
			case 0:	//账号状态正常
				String enpassword = info.getPassword();
				String test = EncryptPassword.encode(password);
				if(test.equals(enpassword)){
					loginResult.setUserId(info.getAdminId());		//登陆成功
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

	/*
	 *  修改密码
	 * */
	@Override
	public void updatePassword(String password, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("adminId").is(userId));
		String enpassword = EncryptPassword.encode(password);
		Update update = Update.update("encrptPassword", enpassword);
		
		adminAccountDao.updateFirst(query, update);
	}

	/*
	 *  查询所有管理员
	 * */
	@Override
	public List<AdminInfo> getUserAccountALL() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("adminId").exists(true));
		List<AdminInfo> plist = adminAccountDao.queryList(query);
		return plist;
	}

	/*
	 *  获取用户信息
	 * */
	@Override
	public AdminInfo getAdminInfoById(int id) {
		// TODO Auto-generated method stub
		BasicDBObject condition = new BasicDBObject();
		condition.put("adminId", id);
		BasicDBObject fields = new BasicDBObject();
		fields.put("adminId", 1);
		fields.put("password", 1);
		fields.put("_id",0);
		Query query = new BasicQuery(condition,fields);
		AdminInfo info = adminAccountDao.queryOne(query);
		return info;
	}

	/*
	 *  更改信息
	 * */
	@Override
	public int change(String type, String username, int userId) {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("adminId").is(userId));
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
		default:
			break;
		}
		adminAccountDao.updateFirst(query, update);
		return 0;
	}

	

}
