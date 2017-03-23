package com.zxjdev.smile.data.utils;

import com.avos.avoscloud.AVUser;
import com.zxjdev.smile.data.exception.AuthorizationException;
import com.zxjdev.smile.data.user.UserEntity;

public class LeanCloudUtils {

  /** page size of query from the cloud */
  public static final int QUERY_LIMIT = 20;

  /**
   * 获取当前登录的用户
   *
   * @return 当前登录的用户对象
   */
  public static UserEntity getCurrentUser() {
    UserEntity currentUser = AVUser.getCurrentUser(UserEntity.class);
    if (currentUser != null) {
      return currentUser;
    } else {
      throw new AuthorizationException("There is no user login.");
    }
  }
}