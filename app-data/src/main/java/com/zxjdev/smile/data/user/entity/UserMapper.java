package com.zxjdev.smile.data.user.entity;

import com.zxjdev.smile.domain.common.base.BaseMapper;
import com.zxjdev.smile.domain.user.User;

import javax.inject.Inject;

public class UserMapper extends BaseMapper<User, UserEntity> {

  @Inject
  public UserMapper() {

  }

  @Override
  public User transform(UserEntity userEntity) {
    User user = new User();
    user.setUsername(userEntity.getUsername());
    user.setNickname(userEntity.getNickName());
    user.setAvatar(userEntity.getAvatar());
    return user;
  }
}
