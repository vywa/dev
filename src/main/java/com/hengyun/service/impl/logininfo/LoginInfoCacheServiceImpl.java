package com.hengyun.service.impl.logininfo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hengyun.dao.impl.RedisClientTemplate;
import com.hengyun.dao.logininfo.LoginInfoDao;
import com.hengyun.domain.loginInfo.LoginInfoCache;
import com.hengyun.domain.loginInfo.constant.UserCatagory;
import com.hengyun.service.logininfo.LoginInfoCacheService;

@Service
public class LoginInfoCacheServiceImpl implements LoginInfoCacheService{

	@Resource
	private RedisClientTemplate redisClientTemplate;
	
	@Resource 
	private LoginInfoDao loginInfoDao;
	
	

	public void loadCache(LoginInfoCache loginInfoCache) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap();
		map.put("userId", String.valueOf(loginInfoCache.getUserId()));
		map.put("username", loginInfoCache.getUsername());
		//map.put("UserCatagory", loginInfoCache.getUserCatagory().toString());
		redisClientTemplate.hmset(loginInfoCache.getTocken(), map);
	}

	public void destroyCache(String tocken) {
		// TODO Auto-generated method stub
		redisClientTemplate.expire(tocken, 0);
	}

	public boolean valideSession(String tocken) {
		// TODO Auto-generated method stub
		return redisClientTemplate.exists( tocken);
	}

	public int getUserId(String tocken) {
		// TODO Auto-generated method stub
		String idStr =redisClientTemplate.hget( tocken, "userId");
		return Integer.valueOf(idStr);
	}

	
	
	public String getUserCatagory(String tocken) {
		// TODO Auto-generated method stub
		String catagory = redisClientTemplate.hget(tocken, "UserCatagory");
		return catagory;
	}

	public boolean loginByTocken(String tocken) {
		// TODO Auto-generated method stub
		if(this.redisClientTemplate.exists(tocken)){
			return true;
		} 
		return false;
	}
	
	
}
