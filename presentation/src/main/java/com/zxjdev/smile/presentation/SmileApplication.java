package com.zxjdev.smile.presentation;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.zxjdev.smile.BuildConfig;
import com.zxjdev.smile.presentation.di.component.ApplicationComponent;
import com.zxjdev.smile.presentation.di.component.DaggerApplicationComponent;
import com.zxjdev.smile.presentation.di.module.ApplicationModule;

import timber.log.Timber;

public class SmileApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initInjector();

        initThirdPartySDK();
    }

    private void initThirdPartySDK() {
        initLeanCloud();

        initTimber();
    }

    private void initLeanCloud() {
        AVOSCloud.initialize(this, BuildConfig.LEANCOULD_APP_ID, BuildConfig.LEANCOULD_APP_KEY);
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
    }

    private void initInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}


