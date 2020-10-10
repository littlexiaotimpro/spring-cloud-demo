package com.practice.spring.cloud.dao;

import com.practice.spring.cloud.entity.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LogDAO {

    Log selectById(@Param("logNo") Integer logNo);

    List<Log> selectByOperator(String operator);

}
