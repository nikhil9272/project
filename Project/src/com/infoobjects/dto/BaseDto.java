package com.infoobjects.dto;
//package name will be simple
public abstract class BaseDto {
    private String code;
    private String name;
    //toMap() abstract method here
    public BaseDto(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
