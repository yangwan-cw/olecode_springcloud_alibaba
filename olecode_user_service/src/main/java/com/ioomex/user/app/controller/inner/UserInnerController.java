package com.ioomex.user.app.controller.inner;


import com.ioomex.module.app.entity.SysUser;
import com.ioomex.service.client.service.UserFeign;
import com.ioomex.user.app.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/inner")
@Slf4j
@Api(tags = "用户管理-内部接口")
public class UserInnerController implements UserFeign {

    @Resource
    private UserService userService;


    @Override
    @ApiOperation(value = "根据用户 ID 获取用户", notes = "通过用户 ID 获取用户信息")
    public SysUser getById(long userId) {
        return userService.getById(userId);
    }

    @Override
    @ApiOperation(value = "根据用户 ID 列表获取用户列表", notes = "通过用户 ID 列表获取用户信息")
    public List<SysUser> listByIds(Collection<Long> idList) {
        return userService.listByIds(idList);
    }
}
