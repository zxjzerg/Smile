package com.zxjdev.smile.data.user.datasource;

import com.zxjdev.smile.data.user.entity.UserEntity;

import javax.inject.Inject;

import rx.Observable;

/**
 * 负责云端用户数据的处理
 *
 * @author Andrew
 */
public class UserCloudDataSource {

  private UserCloudService userCloudService;
  private UserEntity currentUser;

  @Inject
  public UserCloudDataSource(UserCloudService userCloudService, UserEntity currentUser) {
    this.userCloudService = userCloudService;
    this.currentUser = currentUser;
  }

  public Observable<UserEntity> getUser(String id) {
    if (id == null) {
      return Observable.just(currentUser);
    } else {
      return Observable.empty();
    }
  }

  public Observable<String> uploadAvatar(String localPath) {
    return userCloudService.uploadAvatar(localPath);
  }
}
