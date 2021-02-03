package com.spring.cloud.eureka.client.controller;

import com.spring.cloud.common.api.dto.ResponseResult;
import com.spring.cloud.common.api.entity.Log;
import com.spring.cloud.common.api.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Api("客户端访问")
@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Value("${service-url.cloud-provider-log}")
    private String LOG_PREFIX_URL;
    @Value("${service-url.cloud-provider-user}")
    private String USER_PREFIX_URL;

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation("通过主键获取操作日志")
    @GetMapping(value = "/log/primary/{logId}")
    @SuppressWarnings("rawtypes")
    public ResponseResult selectPrimaryLog(@PathVariable("logId") Long logId) {
        ResponseEntity<ResponseResult> responseEntity = restTemplate.getForEntity(LOG_PREFIX_URL + "/primary/" + logId, ResponseResult.class);
        return responseEntity.getBody();
    }

    @ApiOperation("通过操作用户获取相关操作日志")
    @GetMapping(value = "/log/operator/{operator}")
    @SuppressWarnings("rawtypes")
    public ResponseResult selectByOperator(@PathVariable("operator") String operator) {
        ResponseEntity<ResponseResult> responseEntity = restTemplate.getForEntity(LOG_PREFIX_URL + "/operator/" + operator, ResponseResult.class);
        return responseEntity.getBody();
    }

    @ApiOperation("新增操作日志")
    @PostMapping(value = "/log/save")
    @SuppressWarnings("rawtypes")
    public ResponseResult saveLog(@RequestBody Log log) {
        ResponseEntity<ResponseResult> responseEntity = restTemplate.postForEntity(LOG_PREFIX_URL + "/save", log, ResponseResult.class);
        return responseEntity.getBody();
    }

    @ApiOperation("主键查询用户")
    @GetMapping(value = "/user/primary/{userId}")
    @SuppressWarnings("rawtypes")
    public ResponseResult getUserById(@PathVariable("userId") Long userId) {
        ResponseEntity<ResponseResult> responseEntity = restTemplate.getForEntity(USER_PREFIX_URL + "/primary/" + userId, ResponseResult.class);
        return responseEntity.getBody();
    }

    @ApiOperation("查询所有用户")
    @GetMapping(value = "/user/all")
    @SuppressWarnings("rawtypes")
    public ResponseResult getAllUser() {
        ResponseEntity<ResponseResult> responseEntity = restTemplate.getForEntity(USER_PREFIX_URL + "/all", ResponseResult.class);
        return responseEntity.getBody();
    }

    @ApiOperation("新增用户")
    @PostMapping(value = "/user/save")
    @SuppressWarnings("rawtypes")
    public ResponseResult saveUser(@RequestBody User user) {
        ResponseEntity<ResponseResult> responseEntity = restTemplate.postForEntity(USER_PREFIX_URL + "/save", user, ResponseResult.class);
        return responseEntity.getBody();
    }

    @ApiOperation("删除用户")
    @PostMapping(value = "/user/delete/{userId}")
    @SuppressWarnings("rawtypes")
    public ResponseResult deleteUserByKey(@PathVariable("userId") Long userId) {
        ResponseEntity<ResponseResult> responseEntity = restTemplate.postForEntity(USER_PREFIX_URL + "/delete/" + userId, null, ResponseResult.class);
        return responseEntity.getBody();
    }

}
