package com.spring.cloud.provider.user.service;

import com.spring.cloud.common.api.entity.User;

import java.util.List;

public interface UserQueryService {

    User findUserByKey(Long userId);

    List<User> findAllUser();

}
