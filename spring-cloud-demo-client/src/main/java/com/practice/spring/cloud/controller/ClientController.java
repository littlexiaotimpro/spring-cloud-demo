package com.practice.spring.cloud.controller;

import com.practice.spring.cloud.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/primary/{logNo}")
    public Log selectPrimaryLog(@PathVariable("logNo") String logNo) {
        return restTemplate.getForObject("http://127.0.0.1:8001/home/primary/" + logNo, Log.class);
    }

    @GetMapping(value = "/operator/{operator}")
    public List<Log> selectByOperator(@PathVariable("operator") String operator){
        return (List<Log>)restTemplate.getForObject("http://127.0.0.1:8001/home/operator/" + operator, List.class);
    }

}
