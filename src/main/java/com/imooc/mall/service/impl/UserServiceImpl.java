package com.imooc.mall.service.impl;

import com.imooc.mall.dao.UserMapper;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void register(User user) {
        // username不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 0){
            throw new RuntimeException("该用户名已注册");
        }
        // email不能重复
        int countByEmail = userMapper.countByUsername(user.getEmail());
        if (countByEmail > 0){
            throw new RuntimeException("该邮箱已注册");
        }

        // MD5摘要算法（Spring自带）
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        // 将数据写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0){
            throw new RuntimeException("注册失败");
        }
    }
}
