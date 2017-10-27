package com.spring.test.model;

public enum UserRoleType {
    USER("user"),
    ADMIN("admin");

    String userRoleType;
    public String getUserRoleType() {
        return userRoleType;
    }

    UserRoleType(String userRoleType) {
        this.userRoleType = userRoleType;
    }
}
