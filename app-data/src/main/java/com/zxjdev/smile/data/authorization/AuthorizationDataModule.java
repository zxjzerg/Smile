package com.zxjdev.smile.data.authorization;

import com.zxjdev.smile.domain.authorization.AuthorizationRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthorizationDataModule {

  @Provides
  AuthorizationCloudService provideCloudService(AuthorizationCloudServiceLeanCloudImpl cloudService) {
    return cloudService;
  }

  @Provides
  AuthorizationRepository provideRepository(AuthorizationDataRepository repository) {
    return repository;
  }
}
