package com.zxjdev.smile.data.user.datasource;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.zxjdev.smile.data.user.entity.UserEntity;

import java.io.FileNotFoundException;

import javax.inject.Inject;

import io.reactivex.Observable;

public class UserCloudServiceLeanCloudImpl implements UserCloudService {

  private UserEntity currentUser;

  @Inject
  public UserCloudServiceLeanCloudImpl(UserEntity currentUser) {
    this.currentUser = currentUser;
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
        subscriber.onComplete();
      } catch (FileNotFoundException | AVException e) {
        subscriber.tryOnError(e);
      }
    });
  }
}
