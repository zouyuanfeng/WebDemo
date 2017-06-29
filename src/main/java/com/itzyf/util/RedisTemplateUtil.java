package com.itzyf.util;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

/**
 * Created by tl on 17/2/16.
 */
@Repository("templateUtil")
public class RedisTemplateUtil {


    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RedisTemplateUtil(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(String key, Object value) {
        set(key, value, -1);
    }

    public void set(String key, Object value, long expire) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();

        if (value.getClass().isPrimitive())
            valueOperations.set(key, value + "");
        else {
            valueOperations.set(key, new Gson().toJson(value));
        }
        if (expire > 0)
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public <T> T get(String key, Class<T> t) {
        return new Gson().fromJson(redisTemplate.opsForValue().get(key), t);
    }

    public <T> T get(String key, Type typeOfT) {
        return new Gson().fromJson(redisTemplate.opsForValue().get(key), typeOfT);
    }
//    public String getString(String key) {
//        return redisTemplate.opsForValue().get(key);
//    }

//    public void setList(String key, List<?> value) {
//        ListOperations listOperations = redisTemplate.opsForList();
//        listOperations.leftPush(key, value);
//    }
//
//    public Object getList(String key) {
//        return redisTemplate.opsForList().leftPop(key);
//    }
//
//    public void setSet(String key, Set<?> value) {
//        SetOperations setOperations = redisTemplate.opsForSet();
//        setOperations.add(key, value);
//    }
//
//    public Object getSet(String key) {
//        return redisTemplate.opsForSet().members(key);
//    }
//
//
//    public void setHash(String key, Map<String, ?> value) {
//        HashOperations hashOperations = redisTemplate.opsForHash();
//        hashOperations.putAll(key, value);
//    }
//
//    public Object getHash(String key) {
//        return redisTemplate.opsForHash().entries(key);
//    }
//
//
//    public void delete(String key) {
//        redisTemplate.delete(key);
//    }
}