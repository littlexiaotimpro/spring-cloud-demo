package com.spring.cloud.provider.user.dao;

import com.spring.cloud.common.api.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户访问持久层
 *
 * @author XiaoSi
 */
@Mapper
public interface UserDAO {

    Integer saveUser(User user);

    Integer deleteUserByKey(Long userId);

    User selectByKey(Long userId);

}
