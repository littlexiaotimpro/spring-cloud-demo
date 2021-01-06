package com.spring.cloud.provider.log.controller;

import com.spring.cloud.common.api.entity.Log;
import com.spring.cloud.provider.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/home")
public class BaseController {

    @Autowired
    private LogService logService;

    @GetMapping(value = "/primary/{logId}")
    public Log showPrimaryLog(@PathVariable("logId") Long logId) {
        return logService.selectPrimaryLog(logId);
    }

    @GetMapping(value = "/operator/{operator}")
    public List<Log> selectByOperator(@PathVariable("operator") String operator) {
        return logService.selectByOperator(operator);
    }

    @PostMapping(value = "/save/log")
    public Integer saveLog() {
        Log log = new Log();
        log.setLogId(2).setOperator("test").setOperation("insert").setContent("测试新增");
        return logService.saveLog(log);
    }

}
