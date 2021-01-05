package com.spring.cloud.provider.log.service.impl;

import com.spring.cloud.provider.log.service.LogService;
import com.spring.cloud.provider.log.dao.LogDAO;
import com.spring.cloud.common.api.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDAO logDAO;

    @Override
    public Log selectPrimaryLog(Integer logNo) {
        return logDAO.selectById(logNo);
    }

    @Override
    public List<Log> selectByOperator(String operator) {
        return logDAO.selectByOperator(operator);
    }
}
