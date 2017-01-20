package com.zxjdev.smile.presentation.application.di.module;

import com.zxjdev.smile.data.user.AuthorizationService;
import com.zxjdev.smile.data.moment.MomentService;
import com.zxjdev.smile.data.user.IAuthorizationService;
import com.zxjdev.smile.data.moment.IMomentService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    IAuthorizationService provideAuthorizationService(AuthorizationService authorizationService) {
        return authorizationService;
    }

    @Provides
    @Singleton
    IMomentService provideMomentService(MomentService momentService) {
        return momentService;
    }
}
