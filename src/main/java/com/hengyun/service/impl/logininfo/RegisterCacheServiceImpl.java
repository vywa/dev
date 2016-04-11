package com.hengyun.service.impl.logininfo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hengyun.dao.impl.RedisClientTemplate;
import com.hengyun.dao.logininfo.UserAccountDao;
import com.hengyun.domain.loginInfo.constant.AccountStatus;
import com.hengyun.service.logininfo.RegisterCacheService;

@Service
public  class RegisterCacheServiceImpl implements RegisterCacheService{

	@Resource
	private RedisClientTemplate redisClientTemplate;
	
	@Resource 
	private UserAccountDao userAccountDao;

	public void loadRegisterCache(String sign) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap();
		map.put("tryCount", "1");
		map.put("status","unregistered");
		
		redisClientTemplate.hmset(sign,map);
		redisClientTemplate.expire(sign, 3*3600);
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
		String code = null;
		try {
			String key =  redisClientTemplate.hget(sign, "confirmCode");
			code = redisClientTemplate.get(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			code = null;
		}
		return code;
	}

	public void setConfirmCode(String sign,String confirmCode) {
		// TODO Auto-generated method stub
		String key = sign+confirmCode;
		redisClientTemplate.set(key, confirmCode);
		redisClientTemplate.expire(key, 3*60);
		redisClientTemplate.hset(sign, "confirmCode",key);
	}

	public String getStatus(String sign) {
		// TODO Auto-generated method stub
		String status = redisClientTemplate.hget(sign,"status");
		 return status;
	}

	public int getTryCount(String sign) {
		// TODO Auto-generated method stub
		String countStr = redisClientTemplate.hget(sign, "tryCount");
		return Integer.valueOf(countStr);
	}

	public void updateRegisterCache(String sign) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap();
		map.put("tryCount","0");
		map.put("status","registered");
		
		redisClientTemplate.hmset(sign,map);
	}
	
	
	
	
	
}
