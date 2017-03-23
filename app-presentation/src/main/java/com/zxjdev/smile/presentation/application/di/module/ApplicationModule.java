package com.zxjdev.smile.presentation.application.di.module;

import android.app.Application;
import android.content.Context;

import com.zxjdev.smile.domain.base.SchedulerFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.android.schedulers.AndroidSchedulers;

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
    SchedulerFactory provideUseCaseSchedulerFactory() {
        return new SchedulerFactory(AndroidSchedulers.mainThread());
    }
}