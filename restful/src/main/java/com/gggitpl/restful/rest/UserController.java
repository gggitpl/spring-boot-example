package com.gggitpl.restful.rest;

import com.gggitpl.restful.model.User;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wsj
 * 2018\12\12 0012
 */

@Api(value = "users", description = "用户相关操作接口")
@RestController
@RequestMapping("users")
public class UserController {

    @ApiOperation(value = "根据用户ID查询用户信息")
    @GetMapping("{id}")
    public Long get(@PathVariable Long id) {
        return id;
    }

    @ApiOperation(value = "分页获取用户列表")
    @GetMapping
    public List<User> getList(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "15") Integer pageSize) {
        return Lists.newArrayList();
    }

    @ApiOperation(value = "储存用户信息到数据库")
    @PostMapping
    public User save(User user) {
        return user;
    }

    @ApiOperation(value = "根据用户ID更新用户信息")
    @PostMapping("{id}")
    public User update(@PathVariable Long id, User user) {
        return user;
    }

    @ApiOperation(value = "根据用户ID删除用户信息")
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {

    }

}
