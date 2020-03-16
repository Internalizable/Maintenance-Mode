package me.internalizable.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RedisBus {

    private final JedisPool jedisPool;
    private Set<String> channels = new HashSet<>();
    private Map<Object, Set<Method>> listeners = new HashMap<>();

    public RedisBus(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
        CompletableFuture.runAsync(() -> {
           try(Jedis jedis = jedisPool.getResource()) {
               jedis.subscribe(new JedisPubSub() {

                   @Override
                   public void onMessage(String channel, String message) {
                       for(Map.Entry<Object, Set<Method>> entry : listeners.entrySet()) {
                           Object object = entry.getKey();
                           Set<Method> methods = entry.getValue();
                           for(Method method : methods) {
                               MessageHandler handler = method.getAnnotation(MessageHandler.class);
                               if(channel.equalsIgnoreCase(handler.value())) {
                                   try {
                                       method.invoke(object, RedisManager.getGson().fromJson(channel, method.getParameterTypes()[0]));
                                   } catch (IllegalAccessException | InvocationTargetException e) {
                                       e.printStackTrace();
                                   }
                               }
                           }
                       }
                   }
               }, channels.toArray(new String[0]));
           }
        });
    }

    public void registerListener(Object object) {
        Set<Method> methods = new HashSet<>();
        Method[] declaredMethods = object.getClass().getDeclaredMethods();
        for(Method method : declaredMethods) {
            if(method.isAnnotationPresent(MessageHandler.class)) {
                methods.add(method);
                channels.add(method.getAnnotation(MessageHandler.class).value());
            }
        }
        listeners.put(object, methods);
    }

    public void sendPayload(String channel, Payload payload) {
        CompletableFuture.runAsync(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                jedis.publish(channel, RedisManager.getGson().toJson(payload));
            }
        });
    }


}