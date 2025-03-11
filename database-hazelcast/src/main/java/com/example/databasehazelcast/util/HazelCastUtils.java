package com.example.databasehazelcast.util;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.concurrent.TimeUnit;

public class HazelCastUtils {
    private final HazelcastInstance hazelcastInstance;
    private static final String MAP_NAME = "test:cache";
    public HazelCastUtils(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }
    public Object get(String key) {
        IMap<Object, Object> map = hazelcastInstance.getMap(MAP_NAME);
        return map.get(key);
    }
    public void set(String key, String value, Integer ttl, TimeUnit timeUnit) {
        IMap<Object, Object> map = hazelcastInstance.getMap(MAP_NAME);
        map.put(key, value, ttl, timeUnit);
    }
    public void del(String key) {
        IMap<Object, Object> map = hazelcastInstance.getMap(MAP_NAME);
        map.remove(key);
    }
    public void delAllCache() {
        IMap<Object, Object> map = hazelcastInstance.getMap(MAP_NAME);
        map.clear();
    }
}