package com.spring.cloud.provider.user.service.impl;

import com.spring.cloud.common.api.entity.User;
import com.spring.cloud.provider.user.dao.UserDAO;
import com.spring.cloud.provider.user.service.UserModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户逻辑修改服务实现
 *
 * @author XiaoSi
 */
@Service
public class UserModifyServiceImpl implements UserModifyService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public Integer saveUser(User user) {
        return userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public Integer deleteUserByKey(Long userId) {
        return userDAO.deleteUserByKey(userId);
    }
}
