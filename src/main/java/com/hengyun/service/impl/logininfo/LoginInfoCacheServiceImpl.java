package com.hengyun.service.impl.logininfo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hengyun.dao.impl.RedisClientTemplate;
import com.hengyun.dao.logininfo.LoginInfoDao;
import com.hengyun.domain.loginInfo.LoginInfoCache;
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
		map.put("lastLoginTime", String.valueOf(loginInfoCache.getLastLoginTime()));
		map.put("ip", String.valueOf(loginInfoCache.getIp()));
		redisClientTemplate.hmset(loginInfoCache.getTocken(), map);
	}

	/*
	 *  销毁缓存
	 * */
	public void destroyCache(String tocken) {
		// TODO Auto-generated method stub
		redisClientTemplate.expire(tocken, 0);
	}

	/*
	 *  该tocken对应用户是否在线
	 * */
	public boolean valideSession(String tocken) {
		// TODO Auto-generated method stub
		return redisClientTemplate.exists( tocken);
	}

	/*
	 *  根据用户tocken获取用户id
	 * */
	public int getUserId(String tocken) {
		// TODO Auto-generated method stub
		String idStr =redisClientTemplate.hget( tocken, "userId");
		return Integer.valueOf(idStr);
	}

	@Override
	public boolean loginByTocken(String tocken) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
