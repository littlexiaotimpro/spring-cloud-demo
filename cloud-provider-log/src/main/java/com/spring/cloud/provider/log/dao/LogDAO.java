package com.spring.cloud.provider.log.dao;

import com.spring.cloud.common.api.entity.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LogDAO {

    Log selectById(@Param("logId") Long logId);

    List<Log> selectByOperator(String operator);

    Integer saveLog(Log log);

}
