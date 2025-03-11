package com.example.databasehazelcast.config;

import com.example.databasehazelcast.util.HazelCastUtils;
import com.hazelcast.config.*;
import com.hazelcast.instance.impl.HazelcastInstanceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HazelcastConfiguration {
    @Bean
    @Primary
    public Config config() {
        EvictionConfig evictionConfig = new EvictionConfig();
        //数据释放策略[NONE|LRU|LFU]。这是Map作为缓存的一个参数，用于指定数据的回收算法，默认为NONE。
        //
        //NONE：当设置为NONE时，不会发生数据回收，同时max-size会失效。但是任然可以使用time-to-live-seconds和max-idle-seconds参数来控制数据留存时间。
        //
        //LRU：“最近最少使用“策略。
        //
        //LFU：“最不常用的使用”策略。
        evictionConfig.setEvictionPolicy(EvictionPolicy.LRU);
        evictionConfig.setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE);
        Config config = new Config();
        config.setInstanceName("testInstanceName")
                .setClusterName("testClusterName")
                .addMapConfig(new MapConfig()
                        .setName("testName")
                        .setEvictionConfig(evictionConfig)
                        //数据留存时间[0~Integer.MAX_VALUE]。缓存相关参数，单位秒，
                        // 默认为0。这个参数决定了一条数据在map中的停留时间。
                        // 当数据在Map中留存超过这个时间并且没有被更新时，它会根据指定的回收策略从Map中移除。值为0时，意味着无求大。
                        .setTimeToLiveSeconds(10));
        return config;
    }
    @Bean
    public HazelCastUtils hazelCastUtils(Config config) {
        return new HazelCastUtils(HazelcastInstanceFactory.getOrCreateHazelcastInstance(config));
    }
}