package com.imooc.mall.service.impl;

import com.imooc.mall.dao.UserMapper;
import com.imooc.mall.enums.RoleEnums;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

import static com.imooc.mall.enums.ResponseEnum.*;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResponseVo<User> register(User user) {
        // username不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 0){
            // throw new RuntimeException("该用户名已注册");
            return ResponseVo.error(USERNAME_EXITS);
        }
        // email不能重复
        int countByEmail = userMapper.countByUsername(user.getEmail());
        if (countByEmail > 0){
            // throw new RuntimeException("该邮箱已注册");
            return ResponseVo.error(EMAIL_EXITS);
        }

        user.setRole(RoleEnums.CUSTOMER.getCode());
        // MD5摘要算法（Spring自带）
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        // 将数据写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0){
            // throw new RuntimeException("注册失败");
            return ResponseVo.error(ERROR);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo<User> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if(user == null){
            // 用户不存在(返回 用户名或密码错误)
            return ResponseVo.error(USERNAME_OR_PASSWORD);
        }

        if(!user.getPassword().equalsIgnoreCase(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))){
            // 密码错误(返回 用户名或密码错误)
            return ResponseVo.error(USERNAME_OR_PASSWORD);
        }
        user.setPassword("");
        return ResponseVo.success(user);
    }
}
