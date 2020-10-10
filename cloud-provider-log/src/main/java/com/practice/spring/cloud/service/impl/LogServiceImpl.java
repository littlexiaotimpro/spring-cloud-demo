package com.practice.spring.cloud.service.impl;

import com.practice.spring.cloud.dao.LogDAO;
import com.practice.spring.cloud.entity.Log;
import com.practice.spring.cloud.service.LogService;
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
