package com.spring.cloud.provider.user.service.impl;

import com.spring.cloud.common.api.entity.User;
import com.spring.cloud.provider.user.dao.UserDAO;
import com.spring.cloud.provider.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户查询服务实现
 *
 * @author XiaoSi
 */
@Service
public class UserQueryServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User selectByKey(Long userId) {
        return null;
    }
}
