package com.spring.cloud.common.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Log {
    private String logno;
    private String operator;
    private String operation;
    private String content;
    private String createtime;
}
