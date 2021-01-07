package com.spring.cloud.eureka.client.controller;

import com.spring.cloud.common.api.dto.ResponseResult;
import com.spring.cloud.common.api.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    private final String LOG_PREFIX_URL = "http://127.0.0.1:8001/log";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/log/primary/{logId}")
    @SuppressWarnings("rawtypes")
    public ResponseResult selectPrimaryLog(@PathVariable("logId") Long logId) {
        ResponseEntity<ResponseResult> responseEntity = restTemplate.getForEntity(LOG_PREFIX_URL + "/primary/" + logId, ResponseResult.class);
        return responseEntity.getBody();
    }

    @GetMapping(value = "/log/operator/{operator}")
    @SuppressWarnings("rawtypes")
    public ResponseResult selectByOperator(@PathVariable("operator") String operator) {
        ResponseEntity<ResponseResult> responseEntity = restTemplate.getForEntity(LOG_PREFIX_URL + "/operator/" + operator, ResponseResult.class);
        return responseEntity.getBody();
    }

    @PostMapping(value = "/log/save")
    @SuppressWarnings("rawtypes")
    public ResponseResult saveLog(@RequestBody Log log) {
        ResponseEntity<ResponseResult> responseEntity = restTemplate.postForEntity(LOG_PREFIX_URL + "/save", log, ResponseResult.class);
        return responseEntity.getBody();
    }

}
