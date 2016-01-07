package com.hengyun.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hengyun.dao.RedisDataSource;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisDataSourceImpl implements RedisDataSource{

	private static final Logger log =LoggerFactory.getLogger(RedisDataSourceImpl.class);

	private ShardedJedisPool shardedJedisPool;
	
	public ShardedJedisPool getShardedJedisPool() {
		return shardedJedisPool;
	}

	public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
		this.shardedJedisPool = shardedJedisPool;
	}

	


	public ShardedJedis getRedisClient() {
		// TODO Auto-generated method stub
		try {
			ShardedJedis shardJedis = shardedJedisPool.getResource();
			return shardJedis;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("getRedisClient error",e);
		}
		return null;
	}


	public void returnResource(ShardedJedis shardedJedis) {
		// TODO Auto-generated method stub
		shardedJedisPool.returnResource(shardedJedis);
	}


	public void returnResource(ShardedJedis shardedJedis, boolean broken) {
		// TODO Auto-generated method stub
		if(broken) {
			shardedJedisPool.returnBrokenResource(shardedJedis);
		} else {
			shardedJedisPool.returnResource(shardedJedis);
		}
	}
	

	
}
