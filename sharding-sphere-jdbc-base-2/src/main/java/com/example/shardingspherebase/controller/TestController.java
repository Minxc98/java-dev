package com.example.shardingspherebase.controller;

import com.example.shardingspherebase.config.ClientIdInterceptor;
import com.example.shardingspherebase.dao.ClientConfigMapper;
import com.example.shardingspherebase.dao.OrderItemMapper;
import com.example.shardingspherebase.dao.OrderMapper;
import com.example.shardingspherebase.entity.ClientConfig;
import com.example.shardingspherebase.entity.tOrder;
import com.example.shardingspherebase.entity.tOrderItem;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private ClientConfigMapper clientConfigMapper;


    @GetMapping("/select/all/order")
    public List<tOrder> selectAll(){
        try(HintManager hintManager = HintManager.getInstance()){
            hintManager.addDatabaseShardingValue("t_order",getKey());
            return orderMapper.selectAll();
        }
    }


    @GetMapping("/select/all/orderItem")
    public List<tOrderItem> selectAllOrderItem(){
        try(HintManager hintManager = HintManager.getInstance()) {
            hintManager.setDatabaseShardingValue(1);
            return orderItemMapper.selectAll();
        }
    }

    public String getKey() {
        String clientId = ClientIdInterceptor.getClientId();
        if (clientId == null) {
            throw new IllegalArgumentException("client_id is not present in ThreadLocal");
        }

        ClientConfig clientConfig = clientConfigMapper.findByClientId(Long.parseLong(clientId));
        if (clientConfig == null) {
            throw new IllegalArgumentException("No data source found for client_id: " + clientId);
        }

        return clientConfig.getDsName();
    }
}
