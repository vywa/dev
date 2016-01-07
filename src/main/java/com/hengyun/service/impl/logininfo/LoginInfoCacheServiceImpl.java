package com.hengyun.service.impl.logininfo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.hengyun.dao.impl.RedisClientTemplate;
import com.hengyun.dao.logininfo.LoginInfoDao;
import com.hengyun.domain.loginInfo.LoginInfoCache;
import com.hengyun.domain.loginInfo.constant.UserCatagory;
import com.hengyun.service.logininfo.LoginInfoCacheService;

public class LoginInfoCacheServiceImpl implements LoginInfoCacheService{

	@Resource
	private RedisClientTemplate redisClientTemplate;
	
	@Resource 
	private LoginInfoDao loginInfoDao;

	public void loadCache(LoginInfoCache loginInfoCache) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap();
		map.put("ID", String.valueOf(loginInfoCache.getID()));
		map.put("username", loginInfoCache.getUsername());
		map.put("UserCatagory", loginInfoCache.getUserCatagory().toString());
		redisClientTemplate.hmset(loginInfoCache.getTocken(), map);
	}

	public void destroyCache(LoginInfoCache loginInfoCache) {
		// TODO Auto-generated method stub
		redisClientTemplate.expire(loginInfoCache.getTocken(), 0);
	}

	public boolean valideSession(LoginInfoCache loginInfoCache) {
		// TODO Auto-generated method stub
		return redisClientTemplate.exists(loginInfoCache.getTocken());
	}

	public int getUserId(LoginInfoCache loginInfoCache) {
		// TODO Auto-generated method stub
		String idStr =redisClientTemplate.hget(loginInfoCache.getTocken(), "ID");
		return Integer.valueOf(idStr);
	}

	public UserCatagory getUserCatagory(LoginInfoCache loginInfoCache) {
		// TODO Auto-generated method stub
		String catagory = redisClientTemplate.hget(loginInfoCache.getTocken(), "UserCatagory");
		return UserCatagory.valueOf(catagory);
	}
	
	
}
