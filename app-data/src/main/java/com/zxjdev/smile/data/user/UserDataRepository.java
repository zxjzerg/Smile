package com.zxjdev.smile.data.user;

import com.zxjdev.smile.data.user.datasource.UserCloudDataSource;
import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.domain.user.UserRepository;

import javax.inject.Inject;

import rx.Observable;

public class UserDataRepository implements UserRepository {

  private UserCloudDataSource userCloudDataSource;
  private UserMapper userMapper;

  @Inject
  public UserDataRepository(UserCloudDataSource userCloudDataSource, UserMapper userMapper) {
    this.userCloudDataSource = userCloudDataSource;
    this.userMapper = userMapper;
  }

  @Override
  public Observable<User> getUser(String id) {
    return userCloudDataSource.getUser(id).map(userEntity -> userMapper.transform(userEntity));
  }

  @Override
  public Observable<User> getCurrentUser() {
    return userCloudDataSource.getUser(null).map(userEntity -> userMapper.transform(userEntity));
  }

  @Override
  public Observable<String> uploadAvatar(String localPath) {
    return userCloudDataSource.uploadAvatar(localPath);
  }
}