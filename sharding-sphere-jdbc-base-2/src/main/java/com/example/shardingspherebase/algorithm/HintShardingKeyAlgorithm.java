package com.example.shardingspherebase.algorithm;


import com.example.shardingspherebase.dao.ClientConfigMapper;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class HintShardingKeyAlgorithm implements HintShardingAlgorithm<String> {

    @Autowired
    private ClientConfigMapper clientConfigMapper;

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<String> shardingValue) {
        Collection<String> values = shardingValue.getValues();
        String dsName = values.stream().findAny().orElseThrow();
        if (availableTargetNames.contains(dsName)) {
            return Collections.singletonList(dsName);
        } else {
            throw new IllegalArgumentException("Data source name " + dsName + " is not available in target names");
        }
    }



}