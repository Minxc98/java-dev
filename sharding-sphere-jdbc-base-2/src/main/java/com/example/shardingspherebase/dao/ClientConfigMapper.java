package com.example.shardingspherebase.dao;

import com.example.shardingspherebase.entity.ClientConfig;

public interface ClientConfigMapper {

    ClientConfig findByClientId(Long clientId);
}
