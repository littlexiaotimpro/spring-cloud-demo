package com.spring.cloud.provider.log.dao;

import com.spring.cloud.common.api.entity.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LogDAO {

    Log selectById(@Param("logNo") Integer logNo);

    List<Log> selectByOperator(String operator);

}
