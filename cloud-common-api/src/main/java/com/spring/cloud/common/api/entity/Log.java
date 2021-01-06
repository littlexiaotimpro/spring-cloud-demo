package com.spring.cloud.common.api.entity;

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
    private long logId;
    private String operator;
    private String operation;
    private String content;
    private Date createTime;
}
