package com.zxjdev.smile.presentation.user;

import com.zxjdev.smile.domain.common.base.BaseMapper;
import com.zxjdev.smile.domain.user.User;

import javax.inject.Inject;

public class UserModelMapper extends BaseMapper<UserModel, User> {

  @Inject
  public UserModelMapper() {

  }

  @Override
  public UserModel transform(User data) {
    UserModel model = new UserModel();
    model.setUsername(data.getUsername());
    model.setAvatar(data.getAvatar());
    return model;
  }
}
