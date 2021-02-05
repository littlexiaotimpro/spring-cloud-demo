package com.spring.cloud.common.api.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    @ApiModelProperty(value = "日志ID")
    private long logId;
    @ApiModelProperty(value = "操作用户")
    private String operator;
    @ApiModelProperty(value = "操作")
    private String operation;
    @ApiModelProperty(value = "日志内容")
    private String content;
    @ApiModelProperty(value = "创建事件")
    private Date createTime;
}
