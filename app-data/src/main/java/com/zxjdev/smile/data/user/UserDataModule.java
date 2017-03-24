package com.zxjdev.smile.data.user;

import com.avos.avoscloud.AVUser;
import com.zxjdev.smile.data.communal.exception.AuthorizationException;
import com.zxjdev.smile.data.user.datasource.UserCloudService;
import com.zxjdev.smile.data.user.datasource.UserCloudServiceLeanCloudImpl;
import com.zxjdev.smile.domain.user.UserRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class UserDataModule {

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
  UserCloudService provideUserCloudService(UserCloudServiceLeanCloudImpl userCloudService) {
    return userCloudService;
  }

  @Provides
  UserRepository provideUserRepository(UserDataRepository userDataRepository) {
    return userDataRepository;
  }
}
