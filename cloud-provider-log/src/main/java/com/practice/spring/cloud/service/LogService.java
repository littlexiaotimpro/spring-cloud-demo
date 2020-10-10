package com.practice.spring.cloud.service;

import com.practice.spring.cloud.entity.Log;

import java.util.List;

public interface LogService {

    Log selectPrimaryLog(Integer logNo);

    List<Log> selectByOperator(String operator);

}
