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
		String idStr;
		try {
			idStr = redisClientTemplate.get( tocken);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
		return Integer.valueOf(idStr);
	}

	/*
	 *  通过id 获取tocken
	 * */
	public String getTockenById(int id){
		String tocken=null;
		try {
			 tocken = redisClientTemplate.hget(String.valueOf(id), "tocken");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
		return tocken;
	}
	
	@Override
	public boolean loginByTocken(String tocken,int userId,String oldTocken) {
		// TODO Auto-generated method stub
		redisClientTemplate.hset(String.valueOf(userId), "tocken", tocken);
		if(oldTocken!=null){
		redisClientTemplate.expire(oldTocken, 0);
		}
		redisClientTemplate.set(tocken, String.valueOf(userId));
		return true;
	}

	@Override
	public int isOnline(String tocken) {
		// TODO Auto-generated method stub
		String status=null;
		try {
			status= redisClientTemplate.get(tocken);
			int userId = Integer.valueOf(status);
			return userId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
		

	}
	
	
	
}
