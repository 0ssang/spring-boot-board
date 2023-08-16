package com.mysite.sbb.user;

import lombok.Getter;
// 상수형이므로 SETTER없이 GETTER만 구현.
@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    UserRole(String value){
        this.value = value;
    }

    private String value;
}
