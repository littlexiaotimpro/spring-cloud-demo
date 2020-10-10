package com.practice.spring.cloud.controller;

import com.practice.spring.cloud.entity.Log;
import com.practice.spring.cloud.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/home")
public class BaseController {

    @Autowired
    private LogService logService;

    @GetMapping(value = "/primary/{logNo}")
    public Log showPrimaryLog(@PathVariable("logNo") String logNO){
        return logService.selectPrimaryLog(Integer.parseInt(logNO));
    }

    @GetMapping(value = "/operator/{operator}")
    public List<Log> selectByOperator(@PathVariable("operator") String operator){
        return logService.selectByOperator(operator);
    }

}
