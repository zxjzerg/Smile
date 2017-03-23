package com.zxjdev.smile.data.authorization;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthorizationModule {

    @Provides
    AuthorizationCloudService provideCloudService(AuthorizationCloudServiceLeanCloudImpl cloudService) {
        return cloudService;
    }
}
