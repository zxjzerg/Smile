package com.zxjdev.smile.presentation.moment;

import com.zxjdev.smile.presentation.user.UserModel;

public class MomentModel {

    private UserModel owner;
    private String content;

    public UserModel getOwner() {
        return owner;
    }

    public void setOwner(UserModel owner) {
        this.owner = owner;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
