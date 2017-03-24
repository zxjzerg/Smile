package com.zxjdev.smile.presentation.communal.di.module;

import com.zxjdev.smile.data.user.UserDataModule;
import com.zxjdev.smile.domain.communal.base.SchedulerFactory;
import com.zxjdev.smile.domain.user.UserRepository;
import com.zxjdev.smile.domain.user.usecase.GetCurrentUser;
import com.zxjdev.smile.domain.user.usecase.UploadAvatar;

import dagger.Module;
import dagger.Provides;

@Module(includes = UserDataModule.class)
public class UserDomainModule {

  @Provides
  GetCurrentUser provideGetCurrentUser(SchedulerFactory schedulerFactory, UserRepository userRepository) {
    return new GetCurrentUser(schedulerFactory, userRepository);
  }

  @Provides
  UploadAvatar provideUploadAvatar(SchedulerFactory schedulerFactory, UserRepository userRepository) {
    return new UploadAvatar(schedulerFactory, userRepository);
  }
}
