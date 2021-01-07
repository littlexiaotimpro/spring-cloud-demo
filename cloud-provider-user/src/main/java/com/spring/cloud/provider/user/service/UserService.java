package com.spring.cloud.provider.user.service;

import com.spring.cloud.common.api.entity.User;

import java.util.List;

public interface UserService {

    default Integer saveUser(User user) {
        return null;
    }

    default Integer deleteUserByKey(Long userId) {
        return null;
    }

    default User findUserByKey(Long userId) {
        return null;
    }

    default List<User> findAllUser() {
        return null;
    }

}
