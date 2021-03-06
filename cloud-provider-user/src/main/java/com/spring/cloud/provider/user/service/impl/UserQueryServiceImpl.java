package com.spring.cloud.provider.user.service.impl;

import com.spring.cloud.common.api.entity.User;
import com.spring.cloud.provider.user.dao.UserDAO;
import com.spring.cloud.provider.user.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户查询服务实现
 *
 * @author XiaoSi
 */
@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findUserByKey(Long userId) {
        return userDAO.findUserByKey(userId);
    }

    @Override
    public List<User> findAllUser() {
        return userDAO.findAllUser();
    }
}
