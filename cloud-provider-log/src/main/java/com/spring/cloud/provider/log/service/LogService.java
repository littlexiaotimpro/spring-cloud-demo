package com.spring.cloud.provider.log.service;

import com.spring.cloud.common.api.entity.Log;

import java.util.List;

public interface LogService {

    Log selectPrimaryLog(Long logId);

    List<Log> selectByOperator(String operator);

    Integer saveLog(Log log);

}
