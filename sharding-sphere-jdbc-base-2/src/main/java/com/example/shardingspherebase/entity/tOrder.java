package com.example.shardingspherebase.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class tOrder {
    private Long orderId;
    private Long userId;

    public tOrder() {
    }
    public tOrder(Long orderId, Long userId) {
        this.orderId = orderId;
        this.userId = userId;
    }

}
