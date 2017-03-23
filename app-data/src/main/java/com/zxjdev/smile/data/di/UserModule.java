package com.zxjdev.smile.data.di;

import com.avos.avoscloud.AVUser;
import com.zxjdev.smile.data.exception.AuthorizationException;
import com.zxjdev.smile.data.user.UserDataRepository;
import com.zxjdev.smile.data.user.UserEntity;
import com.zxjdev.smile.data.user.datasource.UserCloudService;
import com.zxjdev.smile.data.user.datasource.UserCloudServiceLeanCloudImpl;
import com.zxjdev.smile.domain.user.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

  @Provides
  UserEntity provideCurrentUser() {
    UserEntity currentUser = AVUser.getCurrentUser(UserEntity.class);
    if (currentUser != null) {
      return currentUser;
    } else {
      throw new AuthorizationException("There is no user login.");
    }
  }

  @Provides
  @Singleton
  UserCloudService provideUserCloudService(UserCloudServiceLeanCloudImpl userCloudService) {
    return userCloudService;
  }

  @Provides
  UserRepository provideUserRepository(UserDataRepository userDataRepository) {
    return userDataRepository;
  }
}
