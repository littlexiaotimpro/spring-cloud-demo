package com.spring.cloud.provider.user.controller;

import com.spring.cloud.common.api.config.SwaggerProperties;
import com.spring.cloud.common.api.dto.ResponseResult;
import com.spring.cloud.common.api.entity.User;
import com.spring.cloud.provider.user.service.UserModifyService;
import com.spring.cloud.provider.user.service.UserQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Api("用户模块控制器")
@RestController
@RequestMapping(value = "/user")
@EnableConfigurationProperties({SwaggerProperties.class})
public class UserController {

    @Autowired
    private UserQueryService userQueryService;
    @Autowired
    private UserModifyService userModifyService;

    @ApiOperation("通过主键获取用户")
    @GetMapping(value = "/primary/{userId}")
    public ResponseResult<User> getUserById(@PathVariable(value = "userId") Long userId) {
        User user = userQueryService.findUserByKey(userId);
        if (Objects.isNull(user)) {
            return ResponseResult.failed("用户ID：" + userId + "，不存在！");
        }
        return ResponseResult.success("查询成功", user);
    }

    @ApiOperation("查询所有用户")
    @GetMapping(value = "/all")
    public ResponseResult<List<User>> getAllUser() {
        List<User> allUser = userQueryService.findAllUser();
        return ResponseResult.success("查询成功", allUser);
    }

    @ApiOperation("新增用户")
    @PostMapping(value = "/save")
    public ResponseResult<Integer> saveUser(@RequestBody User user) {
        Integer res = userModifyService.saveUser(user);
        if (Objects.isNull(res) || res.compareTo(0) <= 0) {
            return ResponseResult.failed("新增用户失败");
        }
        return ResponseResult.success("新增用户成功", res);
    }

    @ApiOperation("通过主键删除用户")
    @PostMapping(value = "/delete/{userId}")
    public ResponseResult<Integer> deleteUserByKey(@PathVariable("userId") Long userId) {
        Integer res = userModifyService.deleteUserByKey(userId);
        if (Objects.isNull(res) || res.compareTo(0) <= 0) {
            return ResponseResult.failed("删除用户失败");
        }
        return ResponseResult.success("删除用户成功", res);
    }

    @Value("${config.info}")
    private String configInfo;

    private SwaggerProperties swaggerProperties;

    @Autowired
    public void setSwaggerProperties(SwaggerProperties swaggerProperties) {
        this.swaggerProperties = swaggerProperties;
    }

    @ApiOperation("Spring-Cloud-Config 测试接口")
    @GetMapping("/config/info")
    public ResponseResult<String> getConfigInfo() {
        return ResponseResult.success("测试信息", configInfo);
    }

    @ApiOperation("Spring-Cloud-Config 测试获取 Swagger 参数")
    @GetMapping("/config/properties")
    public ResponseResult<SwaggerProperties> getSwaggerProperties() {
        return ResponseResult.success("测试信息", swaggerProperties);
    }



}
