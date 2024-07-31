package com.ioomex.user.app.controller.inner;


import com.ioomex.module.app.entity.SysUser;
import com.ioomex.service.client.service.UserFeign;
import com.ioomex.user.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/inner")
@Slf4j
public class UserInnerController implements UserFeign {

    @Resource
    private UserService userService;


    @Override
    public SysUser getById(long userId) {
        return userService.getById(userId);
    }

    @Override
    public List<SysUser> listByIds(Collection<Long> idList) {
        return userService.listByIds(idList);
    }
}
