package com.zxjdev.smile.data.entity;

import com.avos.avoscloud.AVUser;

public class UserEntity extends AVUser {

    public static final transient Creator CREATOR;

    static {
        CREATOR = AVObjectCreator.instance;
    }

    public void setNickName(String name) {
        this.put("nickName", name);
    }

    public String getNickName() {
        return this.getString("nickName");
    }
}