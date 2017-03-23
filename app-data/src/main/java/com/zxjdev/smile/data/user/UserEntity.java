package com.zxjdev.smile.data.user;

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

  public void setAvatar(String url) {
    this.put("avatar", url);
  }

  public String getAvatar() {
    return this.getString("avatar");
  }
}