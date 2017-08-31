package com.hzlh.redis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Repository("redisDataSource")
public class RedisDataSourceImpl implements RedisDataSource {

    private static final Logger log = LoggerFactory.getLogger(RedisDataSourceImpl.class);

    @Autowired
    private ShardedJedisPool    shardedJedisPool;

    public ShardedJedis getRedisClient() {
        try {
            ShardedJedis shardJedis = shardedJedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {
            log.error("getRedisClent error", e);
        }
        return null;
    }

	public void returnResource(ShardedJedis shardedJedis) {
    	shardedJedis.close();
    }

    public void returnResource(ShardedJedis shardedJedis, boolean broken) {
    	shardedJedis.close();	
    }
}