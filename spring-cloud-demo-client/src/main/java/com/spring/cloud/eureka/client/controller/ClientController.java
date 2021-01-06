package com.spring.cloud.eureka.client.controller;

import com.spring.cloud.common.api.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/primary/{logId}")
    public Log selectPrimaryLog(@PathVariable("logId") Long logId) {
        return restTemplate.getForObject("http://127.0.0.1:8001/home/primary/" + logId, Log.class);
    }

    @GetMapping(value = "/operator/{operator}")
    public List<Log> selectByOperator(@PathVariable("operator") String operator){
        return (List<Log>)restTemplate.getForObject("http://127.0.0.1:8001/home/operator/" + operator, List.class);
    }

    @PostMapping(value = "/save/log")
    public Integer saveLog(){
        return restTemplate.postForObject("http://127.0.0.1:8001/home/save/log", null, Integer.class);
    }

}
