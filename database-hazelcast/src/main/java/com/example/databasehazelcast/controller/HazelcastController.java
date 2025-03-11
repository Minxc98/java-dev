package com.example.databasehazelcast.controller;

import com.example.databasehazelcast.dto.UserDTO;
import com.example.databasehazelcast.util.HazelCastUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/hazelcast")
public class HazelcastController {
    @Autowired
    private HazelCastUtils hazelCastUtils;

    @PostMapping(value = "/save")
    public String saveMapData(@RequestParam String key, @RequestParam String value) throws Exception {
        UserDTO userDTO=new UserDTO(key,value);
        ObjectMapper mapper = new ObjectMapper();
        hazelCastUtils.set(key, mapper.writeValueAsString(userDTO), 60, TimeUnit.SECONDS);
        return "success";
    }
    @GetMapping(value = "/get")
    public Object getMapData(@RequestParam String key) {
        return hazelCastUtils.get(key);
    }
    @GetMapping(value = "/del")
    public String del(@RequestParam String key) {
        hazelCastUtils.del(key);
        return "success";
    }
    @GetMapping(value = "/clear")
    public String clear() {
        hazelCastUtils.delAllCache();
        return "success";
    }
}