package com.imooc.mall.controller;


import com.imooc.mall.form.UserForm;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.Objects;

import static com.imooc.mall.enums.ResponseEnum.NEED_LOGIN;
import static com.imooc.mall.enums.ResponseEnum.PARAM_ERROR;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @PostMapping("/register")
    public ResponseVo register(@Valid @RequestBody UserForm userForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("注册提交的参数有误,{},{}",
                    Objects.requireNonNull(bindingResult.getFieldError()).getField(),
                    bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(PARAM_ERROR,bindingResult);
        }

        log.info("username={}", userForm.getUsername());
        // return ResponseVo.success();
        return ResponseVo.error(NEED_LOGIN);
    }
}
