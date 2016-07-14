package com.zxjdev.smile.data.entity;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

@AVClassName("Moment")
public class MomentEntity extends AVObject {

    public static final transient Creator CREATOR;

    static {
        CREATOR = AVObjectCreator.instance;
    }

    public MomentEntity() {
        super();
    }

    public void setContent(String content) {
        put("content", content);
    }

    public String getContent() {
        return getString("content");
    }

    public void setOwner(UserEntity user) {
        put("user", user);
    }

    public UserEntity getUser() {
        return getAVUser("user", UserEntity.class);
    }
}
