package com.spring.cloud.provider.log.service;

import com.spring.cloud.common.api.entity.Log;

import java.util.List;

public interface LogService {

    Log selectPrimaryLog(Integer logNo);

    List<Log> selectByOperator(String operator);

}
