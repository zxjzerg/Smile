package com.zxjdev.smile.presentation.moment;

import com.zxjdev.smile.presentation.user.UserModel;

import java.util.Date;

public class MomentModel {

    private UserModel owner;
    private String content;
    private Date createAt;

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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
