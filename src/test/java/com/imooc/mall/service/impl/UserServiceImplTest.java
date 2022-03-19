package com.imooc.mall.service.impl;

import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.enums.RoleEnums;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class UserServiceImplTest {

    private static final String USERNAME = "lisi";
    private static final String PASSWORD = "123456";



    @Autowired
    private IUserService userService;

    @Test
    public void register() {
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("123456");
        user.setEmail("35688333@qq.com");
        user.setRole(RoleEnums.CUSTOMER.getCode());
        userService.register(user);
    }
    @Test
    public void login() {
        register();
        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

}