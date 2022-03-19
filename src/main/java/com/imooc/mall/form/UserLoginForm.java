package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginForm {

    // @NotEmpty 用于集合
    // @NotBlank  用于String判断空格
    // @NotNull  判断是否为null
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
