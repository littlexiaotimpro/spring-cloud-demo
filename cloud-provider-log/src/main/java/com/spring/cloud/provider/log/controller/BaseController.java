package com.spring.cloud.provider.log.controller;

import com.spring.cloud.common.api.dto.ResponseResult;
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
    public ResponseResult<Log> showPrimaryLog(@PathVariable("logId") Long logId) {
        Log log = logService.selectPrimaryLog(logId);
        return ResponseResult.success("查询成功", log);
    }

    @GetMapping(value = "/operator/{operator}")
    public ResponseResult<List<Log>> selectByOperator(@PathVariable("operator") String operator) {
        List<Log> logs = logService.selectByOperator(operator);
        return ResponseResult.success("查询成功", logs);
    }

    @PostMapping(value = "/save/log")
    public ResponseResult<Integer> saveLog(@RequestBody Log log) {
        Integer integer = logService.saveLog(log);
        return ResponseResult.success("新增成功", integer);
    }

}
