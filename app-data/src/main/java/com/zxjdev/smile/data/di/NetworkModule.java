package com.zxjdev.smile.data.di;

import com.zxjdev.smile.data.moment.datasource.MomentCloudService;
import com.zxjdev.smile.data.moment.datasource.MomentCloudServiceLeanCloudImpl;
import com.zxjdev.smile.data.user.datasource.UserCloudService;
import com.zxjdev.smile.data.user.datasource.UserCloudServiceLeanCloudImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

  @Provides
  @Singleton
  UserCloudService provideAuthorizationService(UserCloudServiceLeanCloudImpl userCloudService) {
    return userCloudService;
  }

  @Provides
  @Singleton
  MomentCloudService provideMomentService(MomentCloudServiceLeanCloudImpl momentCloudService) {
    return momentCloudService;
  }
}
