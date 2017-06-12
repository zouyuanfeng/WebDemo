package com.itzyf.service;

import redis.clients.jedis.ShardedJedis;

public interface JedisDataSource {
    public abstract ShardedJedis getRedisClient();
    public void returnResource(ShardedJedis shardedJedis);  
    public void returnResource(ShardedJedis shardedJedis,boolean broken);  
}  