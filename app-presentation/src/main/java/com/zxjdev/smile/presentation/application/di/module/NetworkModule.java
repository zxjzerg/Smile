package com.zxjdev.smile.presentation.application.di.module;

import com.zxjdev.smile.data.moment.datasource.IMomentCloudService;
import com.zxjdev.smile.data.moment.datasource.MomentCloudService;
import com.zxjdev.smile.data.user.datasource.AuthorizationService;
import com.zxjdev.smile.data.user.datasource.IAuthorizationCloudService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    IAuthorizationCloudService provideAuthorizationService(AuthorizationService authorizationService) {
        return authorizationService;
    }

    @Provides
    @Singleton
    IMomentCloudService provideMomentService(MomentCloudService momentCloudService) {
        return momentCloudService;
    }
}
