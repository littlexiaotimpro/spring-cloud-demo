package com.spring.cloud.provider.user.dao;

import com.spring.cloud.common.api.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户访问持久层
 *
 * @author XiaoSi
 */
@Mapper
public interface UserDAO {

    Integer saveUser(User user);

    Integer deleteUserByKey(Long userId);

    User findUserByKey(Long userId);

    List<User> findAllUser();

}
