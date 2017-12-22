package com.zxjdev.smile.data.authorization.datasource;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.zxjdev.smile.data.user.entity.UserEntity;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AuthorizationCloudServiceLeanCloudImpl implements AuthorizationCloudService {

  @Inject
  public AuthorizationCloudServiceLeanCloudImpl() {

  }

  @Override
  public Observable<Void> register(String username, String password) {
    return Observable.create(emitter -> {
      AVUser user = new AVUser();
      user.setUsername(username);
      user.setPassword(password);
      try {
        user.signUp();
        emitter.onComplete();
      } catch (AVException e) {
        emitter.tryOnError(e);
      }
    });
  }

  @Override
  public Observable<Void> login(String username, String password) {
    return Observable.create(emitter -> {
      try {
        AVUser.logIn(username, password, UserEntity.class);
        emitter.onComplete();
      } catch (AVException e) {
        emitter.tryOnError(e);
      }
    });
  }

  @Override
  public Observable<Boolean> checkIsLogined() {
    return Observable.create(emitter -> {
      emitter.onNext(AVUser.getCurrentUser() != null);
      emitter.onComplete();
    });
  }

  @Override
  public Observable<Void> logout() {
    return Observable.create(emitter -> {
      AVUser.logOut();
      emitter.onComplete();
    });
  }
}
