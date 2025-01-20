package com.example.shardingspherebase.dao;

import com.example.shardingspherebase.entity.tOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    tOrder userById(Integer id);

    @Insert("INSERT INTO t_order (user_id) VALUES (#{userId})")
    void insert(@Param("userId") Long userId);


    List<tOrder> selectAll();
}