package com.zxjdev.smile.data.user.datasource;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVUser;
import com.zxjdev.smile.data.user.UserEntity;

import java.io.FileNotFoundException;

import javax.inject.Inject;

import rx.Observable;

public class UserCloudServiceLeanCloudImpl implements UserCloudService {

  private UserEntity currentUser;

  @Inject
  public UserCloudServiceLeanCloudImpl(UserEntity currentUser) {
    this.currentUser = currentUser;
  }

  @Override
  public Observable<Void> register(String username, String password) {
    return Observable.create(subscriber -> {
      AVUser user = new AVUser();
      user.setUsername(username);
      user.setPassword(password);
      try {
        user.signUp();
        subscriber.onCompleted();
      } catch (AVException e) {
        subscriber.onError(e);
      }
    });
  }

  @Override
  public Observable<UserEntity> login(String username, String password) {
    return Observable.create(subscriber -> {
      try {
        subscriber.onNext(AVUser.logIn(username, password, UserEntity.class));
      } catch (AVException e) {
        subscriber.onError(e);
      }
    });
  }

  @Override
  public Observable<Boolean> checkHasAuthorized() {
    return Observable.create(subscriber -> {
      subscriber.onNext(AVUser.getCurrentUser() != null);
    });
  }

  @Override
  public Observable<Void> logout() {
    return Observable.create(subscriber -> {
      AVUser.logOut();
      subscriber.onCompleted();
    });
  }

  @Override
  public Observable<String> uploadAvatar(String localPath) {
    return Observable.create(subscriber -> {
      try {
        AVFile file = AVFile.withAbsoluteLocalPath("avatar.jpg", localPath);
        file.save();
        currentUser.setAvatar(file.getUrl());
        currentUser.save();
        subscriber.onNext(file.getUrl());
        subscriber.onCompleted();
      } catch (FileNotFoundException | AVException e) {
        subscriber.onError(e);
      }
    });
  }
}
