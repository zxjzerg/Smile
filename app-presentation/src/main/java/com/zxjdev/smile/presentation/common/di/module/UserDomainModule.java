package com.zxjdev.smile.presentation.common.di.module;

import com.zxjdev.smile.data.user.di.UserDataModule;
import com.zxjdev.smile.domain.user.UserRepository;
import com.zxjdev.smile.domain.user.usecase.GetCurrentUser;
import com.zxjdev.smile.domain.user.usecase.UploadAvatar;

import dagger.Module;
import dagger.Provides;

@Module(includes = UserDataModule.class)
public class UserDomainModule {

  @Provides
  GetCurrentUser provideGetCurrentUser(UserRepository userRepository) {
    return new GetCurrentUser(userRepository);
  }

  @Provides
  UploadAvatar provideUploadAvatar(UserRepository userRepository) {
    return new UploadAvatar(userRepository);
  }
}
