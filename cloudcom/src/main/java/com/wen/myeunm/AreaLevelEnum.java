package com.wen.myeunm;

/**
 * Created by szty on 2017/7/28.
 * a demo
 */
public enum AreaLevelEnum implements EnumMessage<Integer> {
    Province(1,"省"),
    City(2,"市"),
    District(3,"区");

    private Integer value;
    private String displayName;

    AreaLevelEnum(Integer value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
