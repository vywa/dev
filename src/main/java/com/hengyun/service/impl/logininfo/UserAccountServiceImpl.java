package com.hengyun.service.impl.logininfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.hengyun.common.constant.AccountStatus;
import com.hengyun.dao.logininfo.UserAccountDao;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.impl.BaseServiceImpl;
import com.hengyun.service.logininfo.RegisterCacheService;
import com.hengyun.service.logininfo.UserAccountService;

@Service
public class UserAccountServiceImpl extends BaseServiceImpl<UserAccount,Integer> implements UserAccountService{

	@Resource 
	private UserAccountDao userAccountDao;
	
	@Resource
	private RegisterCacheService registerCacheService;
	
	public UserAccount getUserAccountById(int id) {
		// TODO Auto-generated method stub
		return userAccountDao.queryById(id);
	}


	//获取所有用户账号
	public List<UserAccount> getUserAccountALL() {
		// TODO Auto-generated method stub
		Query query = Query.query(Criteria.where("_id").exists(true));
		return userAccountDao.queryList(query);
	}


	//注册账号
	public int registerAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		return userAccountDao.addUserAccount(userAccount);
		
	}

	//更新账号
	public void updateUserAccount(UserAccount userAccount) {
		// TODO Auto-generated method stub
		userAccountDao.save(userAccount);
		
	}

//用户是否存在

	public boolean existUserAccountBySign(String sign) {
		// TODO Auto-generated method stub
		//查询缓存
			boolean isExist = registerCacheService.existBySign(sign);
			
			if(!isExist){
				//检查是否存在
				Query query = Query.query(Criteria.where("UserAccount.mobilephone").is(sign));
				UserAccount userAccount = userAccountDao.queryOne(query);
				if(userAccount.equals(null)){
					registerCacheService.loadRegisterCache(sign);
					return false;
				} else {
					return true;
				}
			} else {
				if( registerCacheService.getStatus(sign).equals(AccountStatus.REGISTERED)){
					return true;
				} else {
					return false;
				}
				
			}
				
	}

	

	
}
