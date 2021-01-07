package com.spring.cloud.provider.user.service;

import com.spring.cloud.common.api.entity.User;

public interface UserModifyService {

    Integer saveUser(User user);

    Integer deleteUserByKey(Long userId);

}
