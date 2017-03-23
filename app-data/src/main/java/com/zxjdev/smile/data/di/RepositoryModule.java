package com.zxjdev.smile.data.di;

import com.zxjdev.smile.data.moment.MomentDataRepository;
import com.zxjdev.smile.data.user.UserDataRepository;
import com.zxjdev.smile.domain.moment.MomentRepository;
import com.zxjdev.smile.domain.user.UserRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

  @Provides
  UserRepository provideUserRepository(UserDataRepository userDataRepository) {
    return userDataRepository;
  }

  @Provides
  MomentRepository provideMomentRepository(MomentDataRepository momentDataRepository) {
    return momentDataRepository;
  }
}
