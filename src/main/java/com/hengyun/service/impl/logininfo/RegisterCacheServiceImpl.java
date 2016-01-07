package com.hengyun.service.impl.logininfo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.hengyun.dao.impl.RedisClientTemplate;
import com.hengyun.dao.logininfo.UserAccountDao;
import com.hengyun.domain.loginInfo.RegisterCache;
import com.hengyun.domain.loginInfo.constant.AccountStatus;
import com.hengyun.service.logininfo.RegisterCacheService;

public  class RegisterCacheServiceImpl implements RegisterCacheService{

	@Resource
	private RedisClientTemplate redisClientTemplate;
	
	@Resource 
	private UserAccountDao userAccountDao;

	public void loadRegisterCache(String sign) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap();
		map.put("tryCount", "1");
		map.put("status",AccountStatus.UNREGISTERED.toString());
		
		redisClientTemplate.hmset(sign,map);
	}

	public void destroyRegisterCache(String sign) {
		// TODO Auto-generated method stub
		redisClientTemplate.expire(sign, 0);
	}

	public void addTryCount(String sign) {
		// TODO Auto-generated method stub
		redisClientTemplate.hincrBy(sign, "tryCount", 1);

	}

	public boolean existBySign(String sign) {
		// TODO Auto-generated method stub
		return redisClientTemplate.exists(sign);
		
	}

	public String getConfirmCode(String sign) {
		// TODO Auto-generated method stub
		return redisClientTemplate.hget(sign, "confirmCode");
		
	}

	public void setConfirmCode(String sign,String confirmCode) {
		// TODO Auto-generated method stub
		redisClientTemplate.hset(sign, "confirmCode", confirmCode);
	}

	public AccountStatus getStatus(String sign) {
		// TODO Auto-generated method stub
		String status = redisClientTemplate.hget(sign,"status");
		 return AccountStatus.valueOf(status);
	}

	public int getTryCount(String sign) {
		// TODO Auto-generated method stub
		String countStr = redisClientTemplate.hget(sign, "tryCount");
		return Integer.valueOf(countStr);
	}
	
	
	
	
	
}
