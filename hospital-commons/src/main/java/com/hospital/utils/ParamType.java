package com.hospital.utils;

public enum ParamType {
    PHONE("tbPhone","手机号已经注册！"),
    CARDID("tbCardID","身份证已经注册！"),
    EMAIL("tbEmail","邮箱已被使用！"),
    CODE("tbCode","验证码不正确！请重新输入！"),
    PASSWORD("tbPassword","两次密码输入不一致！");
    private ParamType(String name,String msg) {
        this.name = name;
        this.msg = msg;
    }

    private String name;
    private String msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
