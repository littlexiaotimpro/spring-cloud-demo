package com.spring.cloud.provider.user.service;

import com.spring.cloud.common.api.entity.User;

public interface UserService {

    default Integer saveUser(User user) {
        return null;
    }

    default Integer deleteUserByKey(Long userId) {
        return null;
    }

    default User selectByKey(Long userId) {
        return null;
    }

}
