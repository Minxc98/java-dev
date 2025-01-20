package com.example.shardingspherebase.dao;

import com.example.shardingspherebase.entity.tOrderItem;

import java.util.List;

public interface OrderItemMapper {

    List<tOrderItem> selectAll();
}
