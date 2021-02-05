package com.spring.cloud.provider.log.controller;

import com.spring.cloud.common.api.dto.ResponseResult;
import com.spring.cloud.common.api.entity.Log;
import com.spring.cloud.provider.log.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Api("日志模块控制器")
@RestController
@RequestMapping(value = "/log")
public class BaseController {

    @Autowired
    private LogService logService;

    @ApiOperation("通过主键获取操作日志")
    @GetMapping(value = "/primary/{logId}")
    public ResponseResult<Log> showPrimaryLog(@PathVariable("logId") Long logId) {
        Log log = logService.selectPrimaryLog(logId);
        if (Objects.isNull(log)) {
            return ResponseResult.failed("查询ID: " + logId + "，数据不存在！");
        }
        return ResponseResult.success("查询成功", log);
    }

    @ApiOperation("查询用户操作日志")
    @GetMapping(value = "/operator/{operator}")
    public ResponseResult<List<Log>> selectByOperator(@PathVariable("operator") String operator) {
        List<Log> logs = logService.selectByOperator(operator);
        return ResponseResult.success("查询成功", logs);
    }

    @ApiOperation("新增日志")
    @PostMapping(value = "/save")
    public ResponseResult<Integer> saveLog(@RequestBody Log log) {
        Integer res = logService.saveLog(log);
        if (Objects.isNull(res) || res.compareTo(0) <= 0) {
            return ResponseResult.failed("新增日志失败");
        }
        return ResponseResult.success("新增日志成功", res);
    }

}
