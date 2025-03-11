package com.example.shardingspherebase;

import com.example.shardingspherebase.dao.OrderMapper;
import com.example.shardingspherebase.entity.tOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingSphereBaseApplicationTests {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testInsert(){
        for (int i = 0; i < 10; i++) {
            orderMapper.insert(1L);
        }
    }

}
