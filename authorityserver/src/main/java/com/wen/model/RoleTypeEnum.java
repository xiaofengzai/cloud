package com.wen.model;

import com.wen.myeunm.EnumMessage;

public enum RoleTypeEnum implements EnumMessage<Integer> {
    ADMIN(1,"ADMIN"),
    MEMBER(11,"MEMBER");

    private Integer value;

    private String displayName;

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    RoleTypeEnum(Integer value,String displayName) {
        this.value = value;
        this.displayName = displayName;
    }
}
