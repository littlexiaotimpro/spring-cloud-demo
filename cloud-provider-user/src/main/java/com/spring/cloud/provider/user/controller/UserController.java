package com.spring.cloud.provider.user.controller;

import com.spring.cloud.common.api.dto.ResponseResult;
import com.spring.cloud.common.api.entity.User;
import com.spring.cloud.provider.user.service.UserModifyService;
import com.spring.cloud.provider.user.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
        if (Objects.isNull(user)) {
            return ResponseResult.failed("用户ID：" + userId + "，不存在！");
        }
        return ResponseResult.success("查询成功", user);
    }

    @GetMapping(value = "/all")
    public ResponseResult<List<User>> getAllUser() {
        List<User> allUser = userQueryService.findAllUser();
        return ResponseResult.success("查询成功", allUser);
    }

    @PostMapping(value = "/save")
    public ResponseResult<Integer> saveUser(@RequestBody User user) {
        Integer res = userModifyService.saveUser(user);
        if (Objects.isNull(res) || res.compareTo(0) <= 0) {
            return ResponseResult.failed("新增用户失败");
        }
        return ResponseResult.success("新增用户成功", res);
    }

    @PostMapping(value = "/delete/{userId}")
    public ResponseResult<Integer> deleteUserByKey(@PathVariable("userId") Long userId) {
        Integer res = userModifyService.deleteUserByKey(userId);
        if (Objects.isNull(res) || res.compareTo(0) <= 0) {
            return ResponseResult.failed("删除用户失败");
        }
        return ResponseResult.success("删除用户成功", res);
    }

}
