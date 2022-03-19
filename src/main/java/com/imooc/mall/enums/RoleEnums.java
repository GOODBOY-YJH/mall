package com.imooc.mall.enums;

import lombok.Getter;

@Getter
public enum RoleEnums {
    ADMIN(0),
    CUSTOMER(1),
    ;
    Integer code;

    RoleEnums(Integer code) {
        this.code = code;
    }
}
