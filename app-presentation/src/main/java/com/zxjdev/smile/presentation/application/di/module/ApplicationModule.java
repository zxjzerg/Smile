package com.zxjdev.smile.presentation.application.di.module;

import android.app.Application;
import android.content.Context;

import com.zxjdev.smile.domain.base.UseCaseConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return this.application;
    }

    @Provides
    @Singleton
    UseCaseConfig provideUseCaseConfig() {
        return new UseCaseConfig(Schedulers.io(), AndroidSchedulers.mainThread());
    }
}