package me.internalizable.redis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import redis.clients.jedis.JedisPool;

public class RedisManager {

    private static RedisManager instance;

    private final JedisPool jedisPool;
    private final RedisBus redisBus;
    private static Gson gson = new GsonBuilder().create();

    private RedisManager(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
        instance = this;
        redisBus = new RedisBus(jedisPool);
    }

    public static RedisManager create(JedisPool pool) {
        return new RedisManager(pool);
    }

    public static RedisManager getInstance() {
        return instance;
    }

    public static void setInstance(RedisManager instance) {
        RedisManager.instance = instance;
    }

    public static Gson getGson() {
        return gson;
    }

    public static void setGson(Gson gson) {
        RedisManager.gson = gson;
    }

    public RedisBus getRedisBus() {
        return redisBus;
    }


}