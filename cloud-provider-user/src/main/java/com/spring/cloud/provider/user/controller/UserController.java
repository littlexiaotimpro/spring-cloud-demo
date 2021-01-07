package com.spring.cloud.provider.user.controller;

import com.spring.cloud.common.api.dto.ResponseResult;
import com.spring.cloud.common.api.entity.User;
import com.spring.cloud.provider.user.service.UserModifyService;
import com.spring.cloud.provider.user.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserQueryService userQueryService;
    @Autowired
    private UserModifyService userModifyService;

    @GetMapping(value = "/primary/{userId}")
    public ResponseResult<User> getUserById(@PathVariable(value = "userId") Long userId) {
        User user = userQueryService.findUserByKey(userId);
        return ResponseResult.success("查询成功", user);
    }

    @GetMapping(value = "/all")
    public ResponseResult<List<User>> getAllUser() {
        List<User> allUser = userQueryService.findAllUser();
        return ResponseResult.success("查询成功", allUser);
    }

}
